package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem8_5 {

    // 앞서 계산된 결과를 저장하기 위한 dp 테이블을 초기화
    public static int[] dp = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍 진행(바텀 업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            // 현재으이 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.println(dp[x]);
    }
}
