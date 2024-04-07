package com.fanxb.common.p100;

public class Q67 {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        if (m < n) return addBinary(b, a);
        char[] acs = a.toCharArray();
        int temp = 0;
        for (int i = 0; i < m; i++) {
            int ac = acs[m - 1 - i] - '0';
            int bc = n - 1 - i >= 0 ? b.charAt(n - 1 - i) - '0' : 0;
            int val = ac + bc + temp;
            temp = val >= 2 ? 1 : 0;
            acs[m - 1 - i] = (char) ('0' + val % 2);
        }
        return (temp == 1 ? "1" : "") + new String(acs);
    }
}
