package com.fanxb.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22 {
    Set<String> ans;
    //左括号个数
    int lCount;
    //右括号个数
    int rCount;
    StringBuilder temp;

    public List<String> generateParenthesis(int n) {
        ans = new HashSet<>();
        lCount = 0;
        rCount = 0;
        temp = new StringBuilder();
        dfs(n, 2 * n);
        return new ArrayList<>(ans);
    }

    private void dfs(int n, int total) {
        if (temp.length() == total) {
            ans.add(temp.toString());
            return;
        }
        if (lCount < n) {
            lCount++;
            temp.append('(');
            dfs(n, total);
            lCount--;
            temp.deleteCharAt(temp.length() - 1);
        }
        if (rCount < lCount) {
            rCount++;
            temp.append(')');
            dfs(n, total);
            rCount--;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Q22().generateParenthesis(8));
        System.out.println(System.currentTimeMillis() - start);
    }
}
