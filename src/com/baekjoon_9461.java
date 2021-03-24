package com;

import java.util.Scanner;

// 동적 프로그래밍 문제
public class baekjoon_9461 {

    public static long[] arr = new long[101];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            System.out.println(pado(num));
        }
    }

    public static long pado(int N) {

        if (N <= 3) return arr[N];

        if (arr[N] != 0) {
            return arr[N];
        }

        arr[N] = pado(N-2) + pado(N-3);

        return arr[N];
    }
}
