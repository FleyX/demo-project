package com.fanxb.common.p400;

import java.util.*;

public class Q380 {
    private static class RandomizedSet {
        private int[] nums = new int[2*(int)Math.pow(10,5)];
        //记录值-数组index关系
        private Map<Integer,Integer> map =new HashMap();
        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            nums[map.size()]=val;
            map.put(val,map.size());
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.get(val);
            if(index==null){
                return false;
            }
            map.remove(val);
            if(index != map.size()){
                nums[index] = nums[map.size()];
                map.put(nums[index],index);
            }

            return true;
        }

        public int getRandom() {
            int i =(int)Math.ceil(Math.random()*map.size());
            return nums[i];
        }
    }
    static void main() {
        RandomizedSet set = new RandomizedSet();
        set.insert(-1);
        set.remove(-2);
        set.insert(-2);
        System.out.println(set.getRandom());
        set.remove(-1);
        set.insert(-2);
        System.out.println(set.getRandom());
    }
}
