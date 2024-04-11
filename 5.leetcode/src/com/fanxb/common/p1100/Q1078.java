package com.fanxb.common.p1100;

import java.util.LinkedList;

/**
 * @author fanxb
 * @date 2021年12月26日 21:54
 */
public class Q1078 {
    public String[] findOcurrences(String text, String first, String second) {
        LinkedList<String> res = new LinkedList<>();
        String[] strs = text.split(" ");
        for (int i = 0; i < strs.length - 2; i++) {
            if (strs[i].equals(first) && strs[i + 1].equals(second)) {
                res.add(strs[i + 2]);
            }
        }
        return res.toArray(new String[0]);
    }
}
