package com.fanxb.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = new ArrayList<>();
        dfs(arr, n, k, 0, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int n, int k, int index, Stack<Integer> temp, List<List<Integer>> res) {
        if (n == 0) {
            //说明找到一个结果序列
            if (temp.size() == k) {
                //只有刚好k个数才是结果
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > n || temp.size() == k) {
                //前面已经排序过，所以在这里可以进行剪枝操作，如果candidates[index]都小于target了，那就不需要比较后面的了，肯定不满足要求
                //另外只能使用k个数，所以当temp的size为k时说明不能在装了，本条路结束
                return;
            }
            temp.push(candidates[i]);
            dfs(candidates, n - candidates[i], k, i + 1, temp, res);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        new Q216().combinationSum3(3, 9).forEach(System.out::println);
    }

}
