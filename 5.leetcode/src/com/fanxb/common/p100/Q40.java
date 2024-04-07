package com.fanxb.common.p100;

import java.util.*;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        for (int i = index; i < candidates.length; ) {
            if (candidates[i] > target) {
                //前面已经排序过，所以在这里可以进行剪枝操作，如果candidates[index]都小于target了，那就不需要比较后面的了，肯定不满足要求
                return;
            }
            temp.push(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, temp, res);
            temp.pop();
            //手动控制i的增长，对于同一个数字不能重复处理
            int nextI = i + 1;
            while (nextI < candidates.length && candidates[nextI] == candidates[i]) {
                nextI++;
            }
            i = nextI;
        }
    }

    public static void main(String[] args) {
        new Q40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).forEach(System.out::println);
    }

}
