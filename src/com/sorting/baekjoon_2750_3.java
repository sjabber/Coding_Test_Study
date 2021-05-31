package com.sorting;

// Arrays.sort 를 활용해본다.

import java.io.*;
import java.util.Arrays;

public class baekjoon_2750_3 {

    public static void main(String[] args) throws IOException {

        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(array);

            for (int val : array) {
                System.out.println(val);
            }

        } catch (IOException e) {
            System.out.println("Input Error Occurred. ");
        }

    }
}
