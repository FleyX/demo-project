package sort.exchange;

import java.util.Arrays;

/**
 * 类功能简述：插入排序
 * 类功能详述：按照升序讲解
 * 将数组分为有序部分和无序部分，最开始的有序部分为空，无序部分为整个数组
 * 1. 取无序部分第一个值temp
 * 2. 和有序部分从后向前比较，如果有序部分的值大于temp,则该值向后移动一位，继续比较；如果有序部分值小于等于temp，
 * 将temp放到这个值后一位(前面的移动就是为了给temp留位子),a成功插入到有序部分中。
 * 3. 重复1和2
 *
 * @author fanxb
 * @date 2019/7/31 16:46
 */
public class InsertSort {

    public static void sort(Integer[] arr) {
        for (int i = 0, length = arr.length; i < length; i++) {
            //有序部分从后向前比较,直到找到合适的位置
            int j = i, temp = arr[i];
            //如果arr[j-1]<=temp,说明arr[j]需为temp，否则将arr[j-1]向后移动一位
            for (; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            System.out.println("当前数组状态为：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 65, 32, 12, 21};
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
