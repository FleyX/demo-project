package com.fanxb.common.p100;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> has = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            int l = i + 1, r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    String key = nums[i] + "," + nums[l] + "," + nums[r];
                    if (!has.contains(key)) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        has.add(key);
                    }
                    break;
                } else if (sum > 0) r--;
                else l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q15 instance = new Q15();
    }
}
