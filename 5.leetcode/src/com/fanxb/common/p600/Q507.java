package com.fanxb.common.p600;

public class Q507 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        double sqrt = Math.floor(Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return sum == num;
    }
}
