package com.fanxb.common;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int size = words.length, lengthCount = 0, usedWidth = 0;
        for (int i = 0; i < size; i++) {
            lengthCount += words[i].length() + 1;
            if (lengthCount > maxWidth + 1) {
                //说明放不下了
                res.add(dealOne(temp, maxWidth, usedWidth, false));
                temp.clear();
                usedWidth = 0;
                lengthCount = words[i].length() + 1;
            }
            temp.add(words[i]);
            usedWidth += words[i].length();
        }
        if (!temp.isEmpty()) {
            res.add(dealOne(temp, maxWidth, usedWidth, true));
        }
        return res;
    }

    private String dealOne(List<String> temp, int maxWidth, int usedWidth, boolean lastOne) {
        StringBuilder res = new StringBuilder();
        res.append(temp.get(0));
        int size = temp.size();
        if (size == 1) return res.append(" ".repeat(maxWidth - usedWidth)).toString();
        if (lastOne) {
            for (int i = 1; i < size; i++) res.append(' ').append(temp.get(i));
            return res.append(" ".repeat(maxWidth - res.length())).toString();
        } else {
            //每个间隙的长度
            int everyWidth = (maxWidth - usedWidth) / (size - 1);
            //前几个间隙需要加一个空格
            int needPlusCount = (maxWidth - usedWidth) % (size - 1);
            for (int i = 1; i < size; i++) {
                res.append(" ".repeat(everyWidth));
                if (needPlusCount > 0) {
                    res.append(' ');
                    needPlusCount--;
                }
                res.append(temp.get(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Q68 q68 = new Q68();
        System.out.println(q68.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).toString());
    }
}
