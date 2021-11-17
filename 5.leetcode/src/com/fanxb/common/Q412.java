package com.fanxb.common;

import java.util.*;

/**
 * @author fanxb
 * @date 2021-10-13-上午10:36
 */
public class Q412 {
    private static final List<String> RES = new ArrayList<>(10000);

    public List<String> fizzBuzz(int n) {
        if (n <= RES.size()) {
            return RES.subList(0, n);
        }
        for (int i = RES.size() + 1; i <= n; i++) {
            boolean b1 = i % 3 == 0;
            boolean b2 = i % 5 == 0;
            if (b1 && b2) {
                RES.add("FizzBuzz");
            } else if (b1) {
                RES.add("Fizz");
            } else if (b2) {
                RES.add("Buzz");
            } else {
                RES.add(String.valueOf(i));
            }
        }
        return RES;
    }

    public static void main(String[] args) {
        System.out.println(new Q412().fizzBuzz(2));
        System.out.println(new Q412().fizzBuzz(3));
        System.out.println(new Q412().fizzBuzz(5));
        System.out.println(new Q412().fizzBuzz(15));
    }
}
