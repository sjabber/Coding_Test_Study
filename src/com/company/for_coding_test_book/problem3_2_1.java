package com.company.for_coding_test_book;

import java.util.Arrays;
import java.util.Scanner;

public class problem3_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int first = arr[n - 1];
        int second = arr[n - 2];

        int cnt = (m / (k+1)) * k;
        cnt += m % (k+1); // cnt는 가장 큰 수가 나온 횟수

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second;

        System.out.print(result);
    }
}
