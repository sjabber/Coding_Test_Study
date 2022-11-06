package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem8_5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[30001];
        int X = sc.nextInt();

        for (int i = 2; i <= X; i++){
            arr[i] = arr[i-1] + 1;

            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
            if (i % 5 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
            }
        }

        System.out.println(arr[X]);
    }
}
