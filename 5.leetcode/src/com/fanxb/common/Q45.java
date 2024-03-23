package com.fanxb.common;

import java.util.Stack;

/**
 * @author fanxb
 * @date 2021-11-03-下午3:12
 */
public class Q45 {

    public int jump(int[] nums) {
        int maxIndex = 0;//下一跳能到达的最远边界
        int end = 0; //一次跳跃的边界
        int step = 0;//使用的部署
        //只需走到倒数第二个节点即可
        for (int i = 0; i < nums.length-1; i++) {
            //look for next step's max value
            maxIndex = Math.max(maxIndex, i+nums[i]);
            //走到一步的边界了，已经找到下一跳的起点
            if(i==end){
                step++;
                end = maxIndex;
            }
        }
        return step;
    }

    public int solve(int[] nums,int i,int[] map){
        if(i>nums.length-1) return 0;
        if(map[i]>0) return map[i];
        int minStep = 100000,step;
        int v = nums[i];
        for(int j=0;j<v;j++){
            step = solve(nums,i+j+1,map);
            minStep = Math.min(minStep,step+1);
        }
        map[i] = minStep;
        return minStep;
    }

    public int jump1(int[] nums){
        int[] map = new int[nums.length];
        return solve(nums,0,map);
    }


    public static void main(String[] args) {
    }
}
