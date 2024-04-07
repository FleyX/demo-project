package com.fanxb.common.p200;

/**
 * 分割回文串
 *
 * @author fanxb
 * @date 2022/3/9 10:10
 */
public class Q134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            gas[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < length; i++) {
            //try from i
            int sum = 0;
            boolean ok = true;
            for (int j = 0; j < length; j++) {
                sum += gas[(i + j) % length];
                if (sum < 0) {
                    ok = false;
                    i += j;
                    break;
                }
            }
            if (ok) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Q134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
