package com.Dynamic_Programming;

import java.util.Scanner;

public class baekjoon_10030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-2][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(arr[num][0] + " " + arr[num][1]);
        }
    }
}
