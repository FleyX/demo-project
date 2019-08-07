package sort.exchange;

import java.util.Arrays;

/**
 * 类功能简述：希尔排序
 * 类功能详述：以升序为例
 * 希尔排序也是插入排序的一种，是对上面的直接插入排序的一种改进。因为直接插入排序在数组大致有序时效率较高，如果数组完全逆序的情况
 * 下效率就很慢了,因为一次只能移动一个位置，完全逆序的情况下每次插入都会移动非常多的次数，效率很慢。希尔排序的目的就是一次能够移动多个
 * 位置，减少移动次数。详细过程如下：
 * 1. 取一个小于数组长度n的整数n1，将所有间隔为n1的数分成一组，对各组进行直接插入排序.然后n=n1；
 * 2. 重复上述操纵，直到n1=1进行一次完整的插入排序后结束。
 * <p>
 * 总体思想是先一次移动多个位置，让数组整体大致有序，这样当n=1时再直接插入排序速度会快很多。
 *
 * @author fanxb
 * @date 2019/7/31 17:17
 */
public class ShellSort {

    public static void sort(Integer[] arr) {
        int n1 = arr.length / 2;
        // 也可将do/while替换成尾递归
        do {
            //共n1组数据需要进行直接插入排序
            for (int start = 0; start < n1; start++) {
                //对一组执行插入排序，第一个数为arr[start],增量为n1
                for (int i = start; i < arr.length; i += n1) {
                    int j = i, temp = arr[i];
                    for (; j > start && temp < arr[j - n1]; j -= n1) {
                        arr[j] = arr[j - n1];
                    }
                    arr[j] = temp;
                }
            }
            n1 /= 2;
        } while (n1 >= 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 65, 32, 12, 21};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
