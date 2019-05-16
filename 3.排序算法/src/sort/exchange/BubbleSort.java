package sort.exchange;

import java.util.Arrays;

/**
 * 类功能简述：冒泡排序
 * 类功能详述：冒泡排序故名思义就是每轮循环将一个最大或者最小的数放到无序部分的顶部，知道所有的数都是有序的
 *
 * @author fanxb
 * @date 2019/5/15 17:27
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 12, 2, 8, 453, 1, 59, 33};
        for (int i = 0, length = arr.length; i < arr.length - 1; i++) {
            for (int j = 0, tempLength = length - 1 - i; j < tempLength; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
