package com.for_coding_test_book;

import java.io.*;
import java.util.Arrays;
import java.util.function.BiFunction;

public class problem3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int result = 0;

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
            }
            Arrays.sort(arr[i]);
        }

        br.close();

        for (int i = 0; i < N; i++) {
            if (result < arr[i][0]) {
                result = arr[i][0];
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
