package com.fanxb.common;

import java.util.*;

/**
 * TODO
 *
 * @author fanxb
 * @date 2022/3/10 15:10
 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, Stack<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            //说明找到一个结果序列
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                //前面已经排序过，所以在这里可以进行剪枝操作，如果candidates[index]都小于target了，那就不需要比较后面的了，肯定不满足要求
                return;
            }
            temp.push(candidates[i]);
            dfs(candidates, target - candidates[i], i, temp, res);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        new Q39().combinationSum(new int[]{2, 3, 5}, 8).forEach(System.out::println);
    }
}
