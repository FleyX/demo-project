package com.fanxb.common.p100;

public class Q50 {
    public double myPow(double x, int n) {
        if (n < 0) return pow(1 / x, -n);
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 1) return pow(x, n - 1) * x;
        double temp = pow(x, n / 2);
        return temp * temp;
    }

    public double pow1(double x, long n) {
        double res = x;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * x;
            x = x * x;
            n = n >>> 1;
        }
        return res;
    }
}
