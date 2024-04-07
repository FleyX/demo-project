package com.fanxb.common.p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new Stack<>(), new boolean[nums.length], res);
        return res;
    }

    /**
     * dfs搜索
     *
     * @param nums 源数组
     * @param temp 记录已选择的数字
     * @param used 记录已选择数字的位置
     * @param res  保存结果
     * @author fanxb
     * date 2022/3/11 14:20
     */
    public void dfs(int[] nums, Stack<Integer> temp, boolean[] used, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; ) {
            if (!used[i]) {
                temp.push(nums[i]);
                used[i] = true;
                dfs(nums, temp, used, res);
                used[i] = false;
                temp.pop();
                int tempI = i;
                while (i < nums.length && nums[tempI] == nums[i]) {
                    i++;
                }
            } else {
                i++;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new Q47().permuteUnique(new int[]{1, 1, 2}));
    }
}
