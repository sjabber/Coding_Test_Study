package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = graph[i][j];
            }
        }

        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = graph[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i - 1][j + 1], dp[i - 1][j - 1]));
                } else { // 맨 왼쪽 열인 경우
                    dp[i][j] = graph[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.println(max);
    }
}
