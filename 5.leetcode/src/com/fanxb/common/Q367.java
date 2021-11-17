package com.fanxb.common;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author fanxb
 * @date 2021-11-04-下午4:26
 */
public class Q367 {
    private static Set<Integer> valSet = new HashSet<>(10000);

    static {
        Long val;
        for (int i = 1; ; i++) {
            val = i * (long) i;
            if (val > Integer.MAX_VALUE) {
                break;
            } else {
                valSet.add(val.intValue());
            }
        }
    }

    public boolean isPerfectSquare(int num) {
        return valSet.contains(num);
    }
}
