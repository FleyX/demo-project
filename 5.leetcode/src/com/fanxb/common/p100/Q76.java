package com.fanxb.common.p100;

/**
 * 最小覆盖子串
 * 题目地址: https://leetcode-cn.com/problems/minimum-window-substring/
 * 解题思路： 滑动窗口，指定两个指针l,r.r向右滑动直到所有的目标字符都存在，然后再让l向右滑动，直到刚好满足要求，判断当前是否为较小的子串。
 * 然后在让l=l+1,重复上述过程直到r到达末尾
 *
 * @author fanxb
 * Date: 2021/4/2 15:10
 */
public class Q76 {

    public static String solution(String s, String t) {
        int totalChars = t.length();
        int[] target = new int[128];
        for (int i = 0; i < totalChars; i++) {
            target[t.charAt(i)]++;
        }
        //当前最小长度的开始,最小长度的结束
        int start = -1, end = 0;
        int l = 0, r = 0;
        char temp;
        while (r < s.length()) {
            temp = s.charAt(r++);
            if (target[temp] > 0) {
                totalChars--;
            }
            target[temp]--;
            if (totalChars == 0) {
                //说明当前i->j-1的字符串已经满足要求
                // 再让l向右移动，直到刚好满足要求
                while (target[(temp = s.charAt(l))] < 0) {
                    target[temp]++;
                    l++;
                }
                if (start < 0 || r - l < end - start + 1) {
                    //判断当前是否为最优
                    start = l;
                    end = r - 1;
                }
                //重新从i+1开始搜索
                l = l + 1;
                totalChars++;
                target[temp]++;
            }
        }
        return start < 0 ? "" : s.substring(start, end + 1);
    }

    public String minWindow(String s, String t) {
        int sSize = s.length(), needCount = t.length();
        int[] map = new int[128];
        for (int i = 0; i < needCount; i++) map[t.charAt(i)]++;
        int l = 0, r = 0, minL = 0, minR = sSize;
        while (r < sSize) {
            char temp = s.charAt(r);
            if (map[temp] > 0) needCount--;
            map[temp]--;
            if (needCount == 0) {
                //说明包含了所有元素,开始把l向右移动直到刚好包含所有元素
                while (needCount == 0) {
                    temp = s.charAt(l);
                    if (map[temp] == 0) {
                        //说明l这个位置刚好，
                        if ((r - l) < (minR - minL)) {
                            minL = l;
                            minR = r;
                        }
                        needCount++;
                    }
                    map[temp]++;
                    l++;
                }
            }
            r++;
        }
        return minR == sSize ? "" : s.substring(minL, minR + 1);
    }


    public static void main(String[] args) {
        System.out.println(solution("a", "aa"));
    }
}
