package com.fanxb.common.p200;


import java.util.Stack;

public class Q150 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int aliveCount = 0;
                if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1) aliveCount++;
                if (i > 0 && board[i - 1][j] >= 1) aliveCount++;
                if (i > 0 && j < n - 1 && board[i - 1][j + 1] >= 1) aliveCount++;
                if (j > 0 && board[i][j - 1] >= 1) aliveCount++;
                if (j < m - 1 && board[i][j + 1] >= 1) aliveCount++;
                if (i < m - 1 && j > 0 && board[i + 1][j - 1] >= 1) aliveCount++;
                if (i < m - 1 && board[i + 1][j] >= 1) aliveCount++;
                if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] >= 1) aliveCount++;
                if (board[i][j] == 0) {
                    //死到活 -1
                    if (aliveCount == 3) board[i][j] = -1;
                } else {
                    //活到死 2
                    if (aliveCount < 2 || aliveCount > 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] == 2) board[i][j] = 0;
            }
        }
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch (str) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num1 = stack.pop(), num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
    }
}
