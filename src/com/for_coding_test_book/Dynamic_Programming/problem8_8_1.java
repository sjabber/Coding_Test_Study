package com.for_coding_test_book.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class problem8_8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] money = new int[N];
        int[] dp = new int[M+1];

        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }

        for (int i = 1; i <= M; i++) {
            dp[i] = 10001;
        }

        Arrays.sort(money);

        for (int i = 0; i < N; i++) {
            int k = money[i]; // 화폐 단위
            for (int j = k; j <= M; j++) {
                // 점화식
                dp[j] = Math.min(dp[j], dp[j - k] + 1);
            }
        }

        if (dp[M] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
    }
}
