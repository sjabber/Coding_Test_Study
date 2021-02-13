package com.for_coding_test_book;

import java.io.*;
import java.util.Arrays;

public class problem3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] NMK = new String[3];
        NMK = br.readLine().split(" ");
        int N = Integer.parseInt(NMK[0]);
        int M = Integer.parseInt(NMK[1]);
        int K = Integer.parseInt(NMK[2]);
        int result = 0;

        String[] arr = new String[N];
        arr = br.readLine().split(" ");

        br.close();

        // 성능시간 측정
        long start_time = System.currentTimeMillis();

        int[] array = new int[N];
        for(int i=0; i < N; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(array);

        while(M > 0) {
            for(int i = 0; i < K; i++) {
                result += array[N - 1];
                M--;

                if (M <= 0) {
                    break;
                }
            }
            if (M <= 0) {
                break;
            }
            result += array[N - 2];
            M--;
        }
        bw.write(String.valueOf(result));
        long end_time = System.currentTimeMillis();
        long time = (end_time - start_time);
        System.out.println("수행시간 : " + time);
        bw.flush();
        bw.close();

    }
}
