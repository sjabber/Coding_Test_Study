package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Top - Down (재귀) 방식 적용
// 점화식 : dp[i] = Math.max(dp[i - 2] + val[i], dp[i - 3] + val[i - 1] + val[i]
public class baekjoon_2579_1 {

    static Integer[] dp;
    static int[] val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        val = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        dp[0] = val[0]; // 객체이므로 값을 넣어주어야만 함. (디폴트값 없음)
        dp[1] = val[1];

        if (N >= 2) {
            dp[2] = val[1] + val[2];
        }

        System.out.println(find(N));
    }

    // 백트래킹..? 바텀으로 내려가 값을 구한뒤 다시 위로 올라와 최종 값을 도출한다.
    static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N - 2) + val[N], find(N - 3) + val[N - 1] + val[N]);
        }

        return dp[N];
    }
}
