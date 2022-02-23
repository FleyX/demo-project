package com.fanxb.common;

/**
 * 线性扫描，只需找到最大和最小数的差即可，假设第一个数为最小值，从第二个数开始遍历，如果大于最小值则计算利润，如果小于最小值就将最小值设置当前值，然后继续往后便利，知道遍历完毕
 *
 * @author FleyX
 * date 2022/2/23 22:47
 */
public class Q121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minVal) {
                max = Math.max(max, prices[i] - minVal);
            } else {
                minVal = prices[i];
            }
        }
        return max;
    }

}
