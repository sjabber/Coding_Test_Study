package com;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_11399 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int tmp = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            tmp += arr[i];
            result += tmp;
        }

        System.out.print(result);
    }
}
