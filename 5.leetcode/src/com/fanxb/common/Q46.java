package com.fanxb.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.push(nums[i]);
                used[i] = true;
                dfs(nums, temp, used, res);
                used[i] = false;
                temp.pop();
            }
        }
    }

    private static class NewSolution {
        private List<List<Integer>> res;
        private List<Integer> temp;
        private boolean[] cache;

        public List<List<Integer>> permute(int[] nums) {
            res = new LinkedList<>();
            temp = new ArrayList<>(nums.length);
            cache = new boolean[nums.length];
            dfs(nums, nums.length);
            return res;
        }

        private void dfs(int[] nums, int length) {
            if (temp.size() == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < length; i++) {
                if (!cache[i]) {
                    temp.add(nums[i]);
                    cache[i] = true;
                    dfs(nums, length);
                    cache[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Q46().permute(new int[]{1, 1, 2}));
    }
}
