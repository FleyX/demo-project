package com.fanxb.common;

import java.util.*;

public class Q433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(bank.length);
        bankSet.addAll(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        if (startGene.equals(endGene)) return 0;
        int step = 0;
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> cache = new HashSet<>();
        cache.add(startGene);
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.poll();
                List<String> temp = checkDiff(str, chars, bankSet);
                for (String one : temp) {
                    if (one.equals(endGene)) return step;
                    if (cache.contains(one)) continue;
                    queue.offer(one);
                    cache.add(one);
                }
            }
        }
        return -1;
    }

    /**
     * 返回所有的替换情况
     *
     * @param str
     * @param endChar
     * @return
     */
    private List<String> checkDiff(String str, char[] chars, Set<String> bankSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (str.charAt(i) != chars[j]) {
                    String temp = str.substring(0, i) + chars[j] + str.substring(i + 1);
                    if (bankSet.contains(temp)) res.add(temp);
                }
            }
        }
        return res;
    }
}
