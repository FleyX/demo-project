package com.fanxb.common.p1000;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 10:58
 */
public class Q930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //计算前缀和
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //记录前缀和的次数
        Map<Integer, Integer> resultMap = new HashMap<>();
        //适配第一个数就是target的情况
        resultMap.put(0, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = sumArr[i], l = r- goal;
            res += resultMap.getOrDefault(l, 0);
            resultMap.put(r, resultMap.getOrDefault(r, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q930().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
