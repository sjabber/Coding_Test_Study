package com;

import java.util.Scanner;

// 문제가 설명이 너무 어려움.
// 문제를 이해 못해서 문제를 이해하는 정도로 다른사람의 자료를 참고하였음.
// 수행시간 -> 0.5초 -> 동적프로그래밍 필수
public class baekjoon_1149 {

    public static int[][] cost;
    public static int[][] sum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 초기화
        cost = new int[N][3]; // 비용을 담을 배열 초기화
        sum = new int[N][3]; // 각 집마다 가장 저렴한 비용 합을 저장할 배열

        // 각 집의 RGB 색칠 비용을 입력받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // 맨 첫 집의 비용은 넣어줘야함.
        sum[0][0] = cost[0][0]; // 빨
        sum[0][1] = cost[0][1]; // 초
        sum[0][2] = cost[0][2]; // 파


        // 마지막 값이 가장 저렴한 것을 고르면 된다. -> 끝에서 처음으로 타고올라가며 동적프로그래밍
        int result = Math.min(dynamic(N-1, 0), dynamic(N-1, 1));
        result = Math.min(result, dynamic(N-1, 2));

        System.out.print(result);
    }

    public static int dynamic(int N, int color) {

        // 값이 나온 경우는 재방문하지 않도록
        if (sum[N][color] == 0) {

            // 점화식
            if (color == 0) {
                sum[N][0] = Math.min(dynamic(N-1, 1), dynamic(N-1, 2)) + cost[N][0];
            } else if (color == 1) {
                sum[N][1] = Math.min(dynamic(N-1, 0), dynamic(N-1, 2)) + cost[N][1];
            } else {
                sum[N][2] = Math.min(dynamic(N-1, 0), dynamic(N-1, 1)) + cost[N][2];
            }
        }

        return sum[N][color];
    }
}
