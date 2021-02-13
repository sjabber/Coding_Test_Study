package com.sorting;

import java.io.*;

class baekjoon_2750_test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        for (int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(numbers[i] > numbers[j]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }

        for(int var : numbers) {
            bw.write(String.valueOf(var) + "\n");
        }

        bw.flush();
        bw.close();
    }
}