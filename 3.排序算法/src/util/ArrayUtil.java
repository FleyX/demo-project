package util;

/**
 * 类功能简述：数组工具栏
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/5/15 17:43
 */
public class ArrayUtil {

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
