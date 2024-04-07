package com.fanxb.common.p400;

import java.util.*;

public class Q380 {
    private static class RandomizedSet {
        private List<Integer> list;
        private Map<Integer, Integer> map;
        private Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            Integer index = map.get(val);
            if (index != null) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            System.out.println(list.toString());
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.get(val);
            if (index == null) return false;
            int last = list.size() - 1;
            int lastVal = list.get(last);
            list.set(index, lastVal);
            list.remove(last);
            map.remove(val);
            //避免长度为1时将删除的元素放到map
            if (!list.isEmpty()) map.put(lastVal, index);
            System.out.println(list.toString());
            return true;
        }

        public int getRandom() {
            int size = list.size();
            return size == 1 ? list.get(0) : list.get(Math.abs(random.nextInt()) % size);
        }
    }
}
