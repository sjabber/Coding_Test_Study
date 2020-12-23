package com.company;

import java.io.*;

public class baekjoon_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        String[] Card = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int result = 0;
        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < N - 1; i++) {
            A = Integer.parseInt(Card[i]);

            for (int j = i + 1; j < N - 1; j++) {
                B = Integer.parseInt(Card[j]);

                for (int k = j + 1; k <= N - 1; k++) {
                    C = Integer.parseInt(Card[k]);

                    int sum = A + B + C;

                    if (sum == M) {
                        bw.write(String.valueOf(sum));
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    } else if (sum < M) {
                        if (sum > result) {
                            result = sum;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
