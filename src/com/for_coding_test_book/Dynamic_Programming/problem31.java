package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T > 0) {
            int N = sc.nextInt(); // 행
            int M = sc.nextInt(); // 열

            int[][] graph = new int[N + 1][M + 1];
            int[][] dp = new int[N + 1][M + 1];

            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    dp[i][j] = graph[i][j];
                }
            }

            for (int i = 2; i <= M; i++) { // 열
                for (int j = 1; j <= N; j++) { // 행
                    int leftUp, left, leftDown;

                    if (j - 1 == 0) {
                        leftUp = 0;
                    } else {
                        leftUp = dp[j - 1][i - 1];
                    }

                    left = dp[j][i - 1];

                    if (j + 1 > N) {
                        leftDown = 0;
                    } else {
                        leftDown = dp[j + 1][i - 1];
                    }

                    dp[j][i] = dp[j][i] + Math.max(leftUp, Math.max(left, leftDown));
                }
            }

            int max = 0;
            for (int i = 1; i <= N; i++) {
                max = Math.max(max, dp[i][M]);
            }
            System.out.println(max);

            T--;
        }
    }
}
