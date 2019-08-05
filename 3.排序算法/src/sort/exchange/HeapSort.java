package sort.exchange;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * 类功能简述：堆排序，不懂堆的建议看这个<a href="https://www.jianshu.com/p/6b526aa481b1">堆讲解</a>
 * 类功能详述： 基于升序排序.过程如下：
 * <p>
 * 1. 构建大顶堆(升序用大顶堆，降序用小顶堆) ,i=arr.lengh-1,n=arr.lengh
 * 2. 将arr[0]和arr[i]互换,
 * 3. i--
 * 4. 重新将arr 0到i 构建为大顶堆
 * 5. 重复2，3，4直到i=1
 * <p>
 * 构建大顶堆过程如下：
 * 从最后一个非叶子节点开始从下往上进行调整。
 * 将该节点的值调整为max(节点值，直接子节点值），注意如果产生了交换操作还要调整被交换节点,让其也是max（节点值，直接子节点值）,直到被交换节点无子节点
 *
 * @author fanxb
 * @date 2019/7/31 19:02
 */
public class HeapSort {


    private static void sort(Integer[] arr) {
        int n = arr.length;
        //构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, n);
        }
        //排序
        for (int i = n - 1; i > 0; i--) {
            ArrayUtil.swap(arr, 0, arr[i]);
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * Description: 调整堆
     *
     * @param arr    数组
     * @param index  调整index处的对结构
     * @param length 堆大小
     * @author fanxb
     * @date 2019/7/31 19:50
     */
    private static void adjustHeap(Integer[] arr, int index, int length) {
        if (index >= length) {
            return;
        }
        int maxIndex = index;
        for (int i = 2 * index + 1; i < length - 1 && i <= 2 * index + 2; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        //如果进行了交换，还要调整被交换节点
        if (maxIndex != index) {
            ArrayUtil.swap(arr, maxIndex, index);
            adjustHeap(arr, maxIndex, length);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 65, 32, 334, 12, 21, 65, 112, 444443};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
