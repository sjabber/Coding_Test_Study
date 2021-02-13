package com.Dynamic_Programming;

import java.util.Scanner;

public class baekjoon_2748 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long[] arr = new long[91];

        arr[0] = 0;
        arr[1] = 1;
        int num = sc.nextInt();

        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[num]);
    }
}
