package com.fanxb.common;

import java.util.ArrayList;
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

    private void deal(List<List<Integer>> res, List<Integer> cur, int start, int[] sources, int target) {
        if (start >= sources.length || target < sources[start]) {
            return;
        }
        for (int i = start; i < sources.length; i++) {
            if (sources[i] > target) {
                return;
            }
            if (i > start && sources[i] == sources[i - 1]) {
                //第二个重复的元素不需要进行后续操作
                continue;
            }
            cur.add(sources[i]);
            if (sources[i] == target) {
                res.add(new ArrayList<>(cur));
            } else {
                deal(res, cur, i + 1, sources, target - sources[i]);
            }
            //加入后删除当前元素，尝试下一个
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Q40().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }


}
