package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon_2565_2 {

    static Integer[] dp;
    static int[][] wire;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 배열을 선언한다.
        // 굳이 500개 전부 만들 필요 없이 전선의 개수만큼만 만든다.
        dp = new Integer[N];
        wire = new int[N][2];

        for (int i = 0; i < N; i++) {
            wire[i][0] = sc.nextInt();
            wire[i][1] = sc.nextInt();
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 오름차순으로 정렬한다.
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(recur(i), max);
        }

        // 전선 개수 - 최대값
        System.out.println(N - max);
    }

    static int recur(int N) {

        // 탐색하지 않았던 위치라면
        if (dp[N] == null) {

            // 초기화 (자기자신은 무조건 포함되기 때문에 1로 초기화)
            dp[N] = 1;

            for (int i = N+1; i < dp.length; i++) {

                if (wire[N][1] < wire[i][1]) {
                    // 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }

        return dp[N];
    }

}
