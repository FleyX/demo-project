package sort.exchange;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 类功能简述：基数排序
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/8/6 14:33
 */
public class RadixSort {

    @SuppressWarnings("unchecked")
    public static void sort(Integer[] arr) {
        //定义桶
        LinkedList<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }
        int size = arr.length;
        //当前处理第几位的数
        int count = 0;
        while (true) {
            //是否继续进位
            boolean isContinue = false;
            //将数放到桶中
            for (int i = 0; i < size; i++) {
                int temp = arr[i] / (int) Math.pow(10, count) % 10;
                if (!isContinue && temp != 0) {
                    // 如果存在一个数取的值不为0，说明还要继续循环。
                    isContinue = true;
                }
                buckets[temp].addLast(arr[i]);
            }
            if (!isContinue) {
                return;
            }
            //从桶中取出放到arr中,注意以什么顺序放进去的就要以什么顺序取出来（先进先出）
            int index = 0;
            for (int i = 0; i < 10; i++) {
                Integer item;
                while ((item = buckets[i].pollFirst()) != null) {
                    arr[index++] = item;
                }
            }
            //位数+1
            count++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 31, 1, 29, 5, 4, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
