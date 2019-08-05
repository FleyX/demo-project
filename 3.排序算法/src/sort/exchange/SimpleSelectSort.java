package sort.exchange;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * 类功能简述：简单选择排序
 * 类功能详述：以升序为例
 * <p>
 * 简单选择排序顾名思义,每次从无序部分选出一个最大的数，和无序部分的最后一个值交换，重复n-1次后所有的值都变成有序状态
 *
 * @author fanxb
 * @date 2019/7/31 17:49
 */
public class SimpleSelectSort {

    public static void sort(Integer[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < length - i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            ArrayUtil.swap(arr, maxIndex, length - i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 65, 32, 12, 21};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
