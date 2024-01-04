package com.fanxb.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length, leftWidth = maxWidth;
        List<String> lineWord = new LinkedList<>();
        List<List<String>> lineList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (lineWord.isEmpty()) {
                lineWord.add(words[i]);
                leftWidth -= words[i].length();
            } else {
                if (leftWidth >= words[i].length() + 1) {
                    //可以放下
                    lineWord.add(words[i]);
                    leftWidth -= words[i].length() + 1;
                } else {
                    //放不下了，需要新开一行
                    lineList.add(lineWord);
                    lineWord = new LinkedList<>();
                    leftWidth = maxWidth;
                }
            }
        }
        List<String> res = new ArrayList<>(lineList.size());
        for (int i = 0; i < lineList.size() - 1; i++) {
            addToRes(res, lineList.get(i), false);
        }
        addToRes(res, lineList.get(lineList.size() - 1), true);
        return res;
    }

    private void addToRes(List<String> res, List<String> line, boolean lastLine) {
        StringBuilder temp = new StringBuilder();
        temp.append(line.get(0));
        if (lastLine) {
            for (int i = 1; i < line.size(); i++) temp.append(' ').append(line.get(i));
        } else {

        }
    }

    public static void main(String[] args) {
    }
}
