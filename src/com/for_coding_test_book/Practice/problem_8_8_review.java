package com.for_coding_test_book.Practice;


import java.util.Arrays;
import java.util.Scanner;

// 효율적인 화폐구성 복습
public class problem_8_8_review {

    public static int[] d;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N]; // 화폐의 종류를 담는 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP테이블 초기화
        d = new int[M + 1];
        Arrays.fill(d, 10001);
        d[0] = 0;

        // 다이나믹 프로그래밍 (바텀업)
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= M; j++) {
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        if (d[M] == 10001) System.out.println(-1);
        else System.out.println(d[M]);
    }
}
