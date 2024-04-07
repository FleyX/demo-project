package com.fanxb.common.p100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q13 {
    private static Map<Character, Integer> map = new HashMap<>(7);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int cur = map.get(chars[i]), next = i == length - 1 ? 0 : map.get(chars[i + 1]);
            if (cur < next) {
                res += next - cur;
                i++;
            } else {
                res += cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q13 instance = new Q13();
        System.out.println(instance.romanToInt("MCMXCIVI"));
    }
}
