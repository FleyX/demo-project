package com.fanxb.common;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class S1 {
    PriorityQueue<Integer> big = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>((a,b)->b-a);
    int count=0;
    public void Insert(Integer num) {
        if(big.isEmpty()){
            big.offer(num);
        }else if(big.peek()>=num){
            big.offer(num);
            if(big.size()>small.size()+1){
                small.offer(big.poll());
            }
        }else{
            small.offer(num);
            if(big.size()<small.size()){
                big.offer(small.poll());
            }
        }
    }


    public Double GetMedian() {
        if(count==0){
            return null;
        }
        if(count%2==0){
            return ( big.peek()+small.peek())/2.0;
        }else{
            return big.peek()*1.0;
        }
    }

    public static void main(String[] args) {
        S1 s1 = new S1();
        s1.Insert(5);
        s1.Insert(2);
        s1.Insert(3);
        s1.Insert(12);
        s1.Insert(2);
    }
}
