package com.fanxb.common;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.*;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q401 {
    private static Map<Integer, LinkedList<String>> map = new HashMap<>(10);

    static {
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                LinkedList<String> linkedList = map.computeIfAbsent(count(i) + count(j), k -> new LinkedList<>());
                linkedList.add(i + ":" + (j < 10 ? "0" + j : j));
            }
        }
    }

    private static int count(int x) {
        int count = 0;
        while (x > 0) {
            x -= x & (-x);
            count++;
        }
        return count;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return map.getOrDefault(turnedOn, new LinkedList<String>());
    }

    public static void main(String[] args) {
        new Q401().readBinaryWatch(1);
    }
}
