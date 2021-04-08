package com;

import java.util.Scanner;

public class baekjoon_2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] val = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            val[i] = sc.nextInt();
        }

        dp[1] = val[1];

        if (N >= 2) {
            dp[2] = val[2] + val[1];
        }

        // 점화식을 세운다.
        for (int i = 3; i <= N; i++) {
            int N1 = val[i] + val[i - 1] + dp[i - 3];
            int N2 = val[i] + dp[i - 2];
            // 여기까지의 점화식은 잘 세웠음.

            // 아래 dp[i - 1]값과도 비교를 해줘야 한다.
            // 직전의 누적값이 더 큰 경우를 놓쳐선 안된다.
            // 전전전, 전전, 전 세가지 모두 비교..
            int N3 = Math.max(N1, N2);

            dp[i] = Math.max(N3, dp[i - 1]);
        }

        System.out.print(dp[N]);
    }
}
