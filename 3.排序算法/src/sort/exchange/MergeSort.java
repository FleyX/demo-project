package sort.exchange;

import java.util.ArrayList;

/**
 * 类功能简述：归并排序
 * 类功能详述：
 * <p>
 * 定义：<a href="https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F">参见维基百科</a>
 *
 * @author fanxb
 * @date 2019/8/5 16:25
 */
public class MergeSort {

    public static void mergeSort(Integer[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int half = (start + end) / 2;
        mergeSort(arr, start, half);
        mergeSort(arr, half + 1, end);
        merge(arr, start, half, end);
    }

    /**
     * Description:
     *
     * @param arr arr
     * @author fanxb
     * @date 2019/8/5 17:36
     */
    public static void merge(Integer[] arr, int start, int half, int end) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int i = start, j = half + 1;
        // 循环比较，将较小的放到tempList中
        while (i <= half && j <= end) {
            if (arr[i] <= arr[j]) {
                tempList.add(arr[i]);
                i++;
            } else {
                tempList.add(arr[j]);
                j++;
            }
        }
        if (i > half) {
            //说明第一个数组已经完了，将第二个数组的剩余部分放到tempList中
            while (j <= end) {
                tempList.add(arr[j]);
                j++;
            }
        } else {
            //说明第二个数组卖完了，将第二个数组剩余部分放到tempList中
            while (j <= half) {
                //说明第二个数组处理完了
                tempList.add(arr[j]);
                j++;
            }
        }


    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 1, 2, 5, 4, 2, 54};
        mergeSort(arr, 0, arr.length);
    }
}
