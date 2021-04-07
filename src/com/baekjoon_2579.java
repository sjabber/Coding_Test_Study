package com;

import java.util.Arrays;
import java.util.Scanner;

// 동적 프로그래밍
// Bottom-Up (반복문)
// Note 한칸 전 + 세 칸전(합산값) vs 두칸 전(합산값) 중에 더 큰걸 선택하도록 점화식을 세우는게 핵심이다.
public class baekjoon_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] val = new int[N+2];
        int[] dp = new int[N+2];

        Arrays.fill(val, 0);

        for (int i = 1; i <= N; i++) {
            val[i] = sc.nextInt();
        }

        dp[1] = val[1];
        dp[2] = val[1] + val[2]; // 합산값이니까~

        // 그냥 끝까지 다 계산 때려버리고 최고로 높은값 나오는걸 하면 되는거..
        for (int i = 3; i <= N; i++) {

            int one = dp[i - 3] + val[i - 1] + val[i]; // 한칸 업
            int two = dp[i - 2] + val[i]; // 두칸 업

            dp[i] = Math.max(one, two);
        }

        System.out.print(dp[N]);
    }
}
