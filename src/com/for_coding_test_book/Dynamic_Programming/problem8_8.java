package com.for_coding_test_book.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

// 효율적인 화폐구성 (오답..)
public class problem8_8 {

    public static int[] d = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사용 가능한 화폐의 개수
        int M = sc.nextInt(); // 만들고자 하는 금액
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        long startT = System.currentTimeMillis();

        // 화폐를 내림차순으로 정렬한다.
        Arrays.sort(arr);

        // important 놓쳤던 부분, 최소값(min)을 찾아야 하므로 시작할 때 가장 큰수로 채워버리면 됨.
        // 배열 d를 가장 큰 수로 꽉 채운다.
        Arrays.fill(d, 10001);
        d[0] = 0;

        for (int k = 1; k <= M; k++) {
            for (int i = 0; i < N; i++) {
                if (k % arr[i] == 0) {
                    d[k] = Math.min(d[k], d[k - arr[i]] + 1);
                }
            }
        }

        if (d[M] == 10001) System.out.println(-1);
        else System.out.println(d[M]);
        long endT = System.currentTimeMillis();
        System.out.print("실행시간 : " + (startT - endT)/1000);
    }
}
