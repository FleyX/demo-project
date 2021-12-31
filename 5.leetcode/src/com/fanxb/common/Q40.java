package com.fanxb.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        this.deal(res, new LinkedList<>(), 0, candidates, target);
        return res;
    }

    private void deal(List<List<Integer>> res, List<Integer> cur, int i, int[] sources, int target) {
        if (target < sources[i]) {
            return;
        }
        for (; i < sources.length; i++) {
            if (sources[i] > target) {
                return;
            }
            List<Integer> temp = new LinkedList<>(cur);
            temp.add(sources[i]);
            if (sources[i] == target) {
                res.add(temp);
            } else {
                deal(res, temp, i + 1, sources, target - sources[i]);
            }
        }
    }

    public static void main(String[] args) {
        new Q40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }


}
