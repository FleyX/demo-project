package com.fanxb.common.p300;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q290 {
    public boolean wordPattern(String pattern, String s) {
        List<String> arr = Stream.of(s.split(" ")).filter(item -> !item.isEmpty()).collect(Collectors.toList());
        if (arr.size() != pattern.length()) return false;
        String[] map = new String[128];
        Map<String, Character> map1 = new HashMap<>(arr.size());
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = arr.get(i);
            if (map[c] == null) map[c] = str;
            map1.putIfAbsent(str, c);
            if (!map[c].equals(str) || !map1.get(str).equals(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
