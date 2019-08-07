package sort.exchange;

import java.util.Arrays;

/**
 * 类功能简述：计数排序
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/8/6 17:35
 */
public class CountSort {
    /**
     * Description:
     *
     * @param arr 待排序数组
     * @return void
     * @author fanxb
     * @date 2019/8/6 17:36
     */
    public static void sort(Integer[] arr, Integer minValue, Integer maxValue) {
        int range = maxValue - minValue + 1;
        Integer[] numCount = new Integer[range];
        Arrays.fill(numCount, 0);
        for (Integer item : arr) {
            item = item - minValue;
            numCount[item]++;
        }
        int count = 0;
        for (int i = 0; i < range; i++) {
            if (numCount[i] == 0) {
                continue;
            }
            for (int j = 0; j < numCount[i]; j++) {
                arr[count] = minValue + i;
                count++;
            }
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 65, 32, 334, 12, 21, 65, 112, 444443};
        sort(arr, 1, 444443);
        System.out.println(Arrays.toString(arr));
    }
}
