package com;

import java.util.Scanner;

public class baekjoon_2447 {

    public static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 모양을 담을 2차원 배열 선언
        arr = new char[N][N];

        // 재귀호출 함수 (핵심)
        star(0, 0, N, false);

        // 출력의 수가 3^N 만큼 증가하므로 출력속도를 높이기 위해 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);
    }

    // N은 사이즈를 의미한다.
    public static void star(int x, int y, int N, boolean ok) {

        // 공백일 경우
        if (ok) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 경우
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }

    }

}
