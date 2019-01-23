import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * 每个sheet的表头，String为sheet名，String[][] 为object的属性名与表头的对应关系,例如：["id","对象id"]
     */
    private LinkedHashMap<String, String[][]> headers;

    private static final String IE = "msie";
    private static final String OPERA = "opera";
    private static final String SAFARI = "safari";
    private static final String FIREFOX = "mozilla";

    public ExcelUtil(String fileName, HashMap<String, List<?>> data, LinkedHashMap<String, String[][]> headers) {
        this.fileName = fileName;
        this.data = data;
        this.headers = headers;
    }

    /**
     * Description 创建表格
     *
     * @return org.apache.poi.hssf.usermodel.HSSFWorkbook
     * @author fxb
     * @date 2018/8/23
     */
    public SXSSFWorkbook createExcel() throws Exception {
        try {
            //只在内存中保留五百条记录，五百条之前的会写到磁盘上，后面无法再操作
            SXSSFWorkbook workbook = new SXSSFWorkbook(500);
            //遍历headers创建表格
            for (String key : headers.keySet()) {
                this.createSheet(workbook, key, headers.get(key), this.data.get(key));
            }
            return workbook;
        } catch (Exception e) {
            log.error("创建表格失败:{}", e.getMessage());
            throw e;
        }
    }

    public void writeToResponse(SXSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userAgent = request.getHeader("User-Agent");
        String fileName = "Excel-" + this.fileName + ".xls";
        String encodeFileName = URLEncoder.encode(fileName, "UTF8");
        // 如果没有userAgent，则默认使用IE的方式进行编码
        String rtn = "filename=\"" + encodeFileName + "\"";
        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();
            if (userAgent.contains(IE)) {
                // IE浏览器，只能采用URLEncoder编码
                rtn = "filename=\"" + encodeFileName + "\"";
            } else if (userAgent.contains(OPERA)) {
                // Opera浏览器只能采用filename*
                rtn = "filename*=UTF-8''" + encodeFileName;
            } else if (userAgent.contains(SAFARI)) {
                // Safari浏览器，只能采用ISO编码的中文输出
                rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
            }  else if (userAgent.contains(FIREFOX)) {
                // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
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
    private void createSheet(SXSSFWorkbook workbook, String sheetName, String[][] header, List<?> data) throws Exception {
        Sheet sheet = workbook.createSheet(sheetName);
        // 单元行，单元格
        Row row;
        Cell cell;
        //列数
        int cellNum = header.length;
        //设置表头
        row = sheet.createRow(0);
        for (int i = 0; i < cellNum; i++) {
            cell = row.createCell(i);
            String str = header[i][1];
            cell.setCellValue(str);
            //设置列宽为表头的宽度+4
            sheet.setColumnWidth(i, (str.getBytes("utf-8").length + 6) * 256);
        }

        int rowNum = data.size();
        if (rowNum == 0) {
            return;
        }
        //获取Object 属性名与field属性的映射，后面通过反射获取值来设置到cell
        Field[] fields = data.get(0).getClass().getDeclaredFields();
        Map<String, Field> fieldMap = new HashMap<>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            fieldMap.put(field.getName(), field);
        }
        Object object;
        for (int i = 0; i < rowNum; i++) {
            row = sheet.createRow(i + 1);
            object = data.get(i);
            for (int j = 0; j < cellNum; j++) {
                cell = row.createCell(j);
                this.setCell(cell, object, fieldMap, header[j][0]);
            }
        }
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 设置单元格,根据fieldName获取对应的Field类，使用反射得到值
     *
     * @param cell cell
     * @param obj obj
     * @param fieldMap  属性名与Field的映射
     * @param fieldName 属性名
     */
    private void setCell(Cell cell, Object obj, Map<String, Field> fieldMap, String fieldName) throws Exception {
        Field field = fieldMap.get(fieldName);
        if(field == null){
            throw new Exception("找不到 "+fieldName+" 数据项");
        }
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

}