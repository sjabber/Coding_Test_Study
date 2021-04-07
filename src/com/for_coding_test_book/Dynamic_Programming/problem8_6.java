package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

// 다이나믹 프로그래밍 (난이도 중)
// 첫번째 줄에 식량창고의 개수 N이 주어진다. (3 <= N <= 100)
// 둘째 줄에 식량창고에 저장된 식량의 개수 K가 공백으로 구분지어 주어진다. (0 <= K <= 1000)
// 첫째 줄에 개미전사가 얻을 수 있는 식량의 최대값을 구하세요.

// 입력예시
// 4
// 1 3 1 5

// 출력예시
// 8

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
        // 점화식
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + val[i]);
        }

        return dp[N];
    }
}
