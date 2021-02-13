package com.for_coding_test_book.Practice;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class problem3_3_review {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(array[i]);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (result < array[i][0]) {
                result = array[i][0];
            }
        }

        System.out.println(result);
    }
}
