package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

// Note 바닥 공사
// 잘 모르겠으면 나동빈 강의 들으면 이해됨
// 점화식 -> DP[N] = DP[N-2] * 2 + DP[N-1]
public class problem8_7_2 {
    public static void main(String[] args) {
        int[] dp = new int[1001];

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 796796;
        }

        System.out.println(dp[N]);
    }
}
