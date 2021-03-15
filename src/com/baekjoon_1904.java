package com;

import java.util.Scanner;

public class baekjoon_1904 {

    public static int[] dp = new int[1000001];

    public static int tile(int num) {
        if (num == 1 || num == 0) return dp[1];
        if (dp[num] != 0) return dp[num];
        else {
            dp[num] = (tile(num - 2) + tile(num - 1)) % 15746;
            return dp[num];
        }
    }

    public static void main(String[] args) {
        dp[0] = 1;
        dp[1] = 1;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(tile(N));
    }
}

// 결과값이 피보나치수열의 특징을 가진다.
// 이를토대로 점화식을 세워 동적프로그래밍!