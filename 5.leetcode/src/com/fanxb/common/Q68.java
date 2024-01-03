package com.fanxb.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length, int leftWidth = maxWidth;
        List<String> lineWord = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (lineWord.isEmpty()) {
                lineWord.add(words[i]);
                leftWidth -= words[i].length();
            } else {
                if (leftWidth >= words[i].length() + 1){
                    //可以放下
                }else{
                    //hao
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
