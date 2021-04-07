package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+2]; // 상담에 걸리는 시간
        int[] P = new int[N+2]; // 상담비용
        int[] dp = new int[N+2]; // important 해당 날짜 이후로 받을 수 있는 최대 금액

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 꼭 처음부터 시작한다는 고정관념을 버리자.
        for (int i = N; i >= 1; i--) {

            // 현재 상담의 종료일
            int end_day = T[i] + i;

            // N + 1일 까지 일 할 수 있으므로
            if (end_day <= N + 1) {
                dp[i] = Math.max(dp[i+1], dp[end_day] + P[i]) ;
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.print(dp[1]);

    }
}
