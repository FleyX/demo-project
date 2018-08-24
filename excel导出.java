package com.infinova.oms.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description 支持多sheet表格
 *
 * @author fxb
 * @Date 2018-08-23
 */
public class ExcelUtil {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 表格文件名
     */
    private String fileName;
    /**
     * 表格数据项，string为sheet名，List<Object[]> 为这个sheet的数据
     */
    private HashMap<String, List<?>> data;
    /**
     * 每个sheet的表头，String为sheet名，String[][] 为表头项与表头项对应到object的属性名,例如：["id","对象id"]
     */
    private LinkedHashMap<String, String[][]> headers;

    public ExcelUtil(String fileName, HashMap<String, List<?>> data, LinkedHashMap<String, String[][]> headers) {
        this.fileName = fileName;
        this.data = data;
        this.headers = headers;
        this.exportExcelUtil = new ExportExcelUtil();
    }

    /**
     * Description 创建表格
     *
     * @return org.apache.poi.hssf.usermodel.HSSFWorkbook
     * @author fxb
     * @date 2018/8/23
     */
    public HSSFWorkbook createExcel() throws Exception {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 遍历headers创建表格
            for (String key : headers.keySet()) {
                this.createSheet(workbook, key, headers.get(key), this.data.get(key));
            }
            return workbook;
        } catch (Exception e) {
            log.error("创建表格失败:{}", e.getMessage());
            throw e;
        }
    }

    public void writeToResponse(HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String userAgent = request.getHeader("User-Agent");
        String fileName = "Excel-" + this.fileName + ".xls";
        String encodeFileName = URLEncoder.encode(fileName, "UTF8");
        // 如果没有userAgent，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
        String rtn = "filename=\"" + encodeFileName + "\"";
        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();
            // Opera浏览器只能采用filename*
            if (userAgent.indexOf("opera") != -1) {
                rtn = "filename*=UTF-8''" + encodeFileName;
            }
            // Safari浏览器，只能采用ISO编码的中文输出
            else if (userAgent.indexOf("safari") != -1) {
                rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
            }
            // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
            else if (userAgent.indexOf("applewebkit") != -1) {
                encodeFileName = MimeUtility.encodeText(fileName, "UTF8", "B");
                rtn = "filename=\"" + encodeFileName + "\"";
            }
            // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
            else if (userAgent.indexOf("mozilla") != -1) {
                rtn = "filename*=UTF-8''" + encodeFileName;
            }
        }
        String headStr = "attachment;  " + rtn;
        response.setContentType("APPLICATION/ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", headStr);
        OutputStream out1 = response.getOutputStream();
        workbook.write(out1);
    }

    /**
     * 创建一个sheet
     *
     * @param workbook  workbook
     * @param sheetName 名称
     * @param header    表头
     * @param data      数据
     */
    private void createSheet(HSSFWorkbook workbook, String sheetName, String[][] header, List<?> data)
            throws Exception {
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 列数
        int cellNum = header.length;
        // 单元行，单元格
        HSSFRow row;
        HSSFCell cell;
        // 表头单元格样式
        HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
        // 设置表头
        row = sheet.createRow(0);
        for (int i = 0; i < cellNum; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(columnTopStyle);
            String str = header[i][1];
            cell.setCellValue(str);
            // 设置列宽为表头的文字宽度+6个半角符号宽度
            sheet.setColumnWidth(i, (str.getBytes("utf-8").length + 6) * 256);
        }

        int rowNum = data.size();
        if (rowNum == 0) {
            return;
        }
        // 获取Object 属性名与field属性的映射，后面通过反射获取值来设置到cell
        Field[] fields = data.get(0).getClass().getDeclaredFields();
        Map<String, Field> fieldMap = new HashMap<>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            fieldMap.put(field.getName(), field);
        }
        Object object;
        HSSFCellStyle cellStyle = this.getStyle(workbook);
        for (int i = 0; i < rowNum; i++) {
            row = sheet.createRow(i + 1);
            object = data.get(i);
            for (int j = 0; j < cellNum; j++) {
                cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                this.setCell(cell, object, fieldMap, header[j][0]);
            }
        }

    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 设置单元格,根据fieldName获取对应的Field类，使用反射得到值
     *
     * @param cell
     * @param obj
     * @param fieldMap  属性名与Field的映射
     * @param fieldName 属性名
     */
    private void setCell(HSSFCell cell, Object obj, Map<String, Field> fieldMap, String fieldName) throws Exception {
        //获取该属性的Field对象
        Field field = fieldMap.get(fieldName);
        //通过反射获取属性的值，由于不能确定该值的类型，用下面的判断语句进行合适的转型
        Object value = field.get(obj);
        if (value == null) {
            cell.setCellValue("");
        } else {
            switch (field.getGenericType().getTypeName()) {
            case "java.lang.String":
                cell.setCellValue((String) value);
                break;
            case "java.lang.Integer":
            case "int":
                cell.setCellValue((int) value);
                break;
            case "java.lang.Double":
            case "double":
                cell.setCellValue((double) value);
                break;
            case "java.util.Date":
                cell.setCellValue(this.dateFormat.format((Date) value));
                break;
            default:
                cell.setCellValue(obj.toString());
            }
        }
    }
    /**
     * 设置表头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }

    /**
     * 
     * Description: 数据单元格样式
     * 
     * @param workbook
     * @return
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        // font.setFontHeightInPoints((short)10);
        // 字体加粗
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }

}
