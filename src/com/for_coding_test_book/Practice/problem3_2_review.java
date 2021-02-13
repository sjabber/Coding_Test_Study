package com.for_coding_test_book.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class problem3_2_review {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int result = 0;

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                result += array[N-1];
                i++;
            }
            result += array[N-2];
        }

        System.out.println(result);
    }
}
