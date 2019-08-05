package sort.exchange;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * 类功能简述：快速排序
 * 类功能详述：
 * 1.使用了分治的思想，先取一个数作为基数（一般选第一个数），然后将这个数移动到一个合适的位置使左边的都比它小，右边的都比他大
 * 2.递归处理这个数左边的数和右边的数，直到所有的数都有序。
 * 直到所有的数都有序
 *
 * @author fanxb
 * @date 2019/5/15 17:35
 */
public class QuickSort {

    private static void deal(Integer[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = arr[start], i = start, j = end;
        while (i < j) {
            //在右边找一个比基数小的数,直到i,j相等
            while (arr[j] >= base && j > i) {
                j--;
            }

            //在左边找一个比基数大的数,直到i,j相等
            while (arr[i] <= base && j > i) {
                i++;
            }
            //如果ij不相等，交换其值
            if (i < j) {
                ArrayUtil.swap(arr, i++, j--);
            }
        }
        //此时i等于j，交换基数和i/j,使左边的数小于等于基数，右边的数大于等于基数
        if (start != i) {
            ArrayUtil.swap(arr, start, i);
        }
        deal(arr, start, i - 1);
        deal(arr, j + 1, end);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 43, 2, 7, 5, 6, 555, 200, 21};
        deal(arr, 0, arr.length - 1);
        System.out.println("结果" + Arrays.toString(arr));
    }
}
