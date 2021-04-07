package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem8_6 {

    static int[] dp;
    static int[] val;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[N + 1];
        val = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int tmp = sc.nextInt();
            val[i] = tmp;
        }

        dp[1] = val[1];
        dp[2] = val[2];

        System.out.print(dynamic());
    }

    public static int dynamic() {

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + val[i]);
        }

        return dp[N];
    }
}
