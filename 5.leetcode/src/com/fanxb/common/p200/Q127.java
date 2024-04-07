package com.fanxb.common.p200;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> cache = new HashSet<>();
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        cache.add(beginWord);
        int res = Integer.MAX_VALUE;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                String str = queue.poll();
                boolean continueQueue = false;
                for (int i = 0; i < str.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);
                        if (c != str.charAt(i)) {
                            StringBuilder builder = new StringBuilder(str);
                            builder.setCharAt(i, c);
                            String newStr = builder.toString();
                            if (!set.contains(newStr) || cache.contains(newStr)) {
                                continue;
                            }
                            if (endWord.equals(newStr)) {
                                res = Math.min(res, step);
                                continueQueue = true;
                                break;
                            }
                            cache.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    if (continueQueue) break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        new Q127().ladderLength("hot", "dog", Arrays.asList("hot", "dog"));
    }
}
