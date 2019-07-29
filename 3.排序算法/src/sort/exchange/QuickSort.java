package sort.exchange;

import util.ArrayUtil;
import util.NumberUtil;

import java.util.Arrays;

/**
 * 类功能简述：快速排序
 * 类功能详述：使用了分治的思想，先取一个数，然后让这个数的左边都是小于等于它的，右边都大于等于它，然后左边右边分布做同样的处理，
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
        int baseIndex = NumberUtil.getRandom(start, end);
        int base = arr[baseIndex], i = start, j = end;
        while (i < j) {
            while (arr[j] >= base && j > i) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }


            if (i < j) {
                ArrayUtil.swap(arr, i++, j--);
                System.out.println(Arrays.toString(arr));
            }
        }
        boolean isSwap = (baseIndex > j && arr[baseIndex] < arr[j]) || (baseIndex < j && arr[baseIndex] > arr[j]);
        if (isSwap) {
            ArrayUtil.swap(arr, baseIndex, i);
        }
        System.out.println(Arrays.toString(arr));
        deal(arr, start, i - 1);
        deal(arr, j + 1, end);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 43, 2, 3, 4, 5, 6, 7, 5, 6, 555, 12, 31, 5, 5};
        deal(arr, 0, arr.length - 1);
    }
}
