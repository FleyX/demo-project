package com.fanxb.common;

/**
 * @author fanxb
 * @date 2021-09-23-上午11:27
 */
public class Q326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
