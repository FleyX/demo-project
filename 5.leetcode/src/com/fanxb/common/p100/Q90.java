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
public class Q90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new Stack<>(), res);
        return res;
    }

    /**
     * dfs搜索
     *
     * @param nums 源数组
     * @param temp 记录已选择的数字
     * @param res  保存结果
     * @author fanxb
     * date 2022/3/11 14:20
     */
    public void dfs(int[] nums, int index, Stack<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ) {
            temp.push(nums[i]);
            dfs(nums, i + 1, temp, res);
            temp.pop();
            int tempI = i;
            while (i < nums.length && nums[i] == nums[tempI]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q90().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
