package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] APT = new int[15][14]; // 각각 층수, 호수

        int N = Integer.parseInt(bf.readLine()); // 반복횟수
        int n = 0;

        for(int i = 0; i < 14; i++) {
            APT[0][i] = i+1; // 0번 = 1호, 1번 = 2호 ... 13번 = 14호
            APT[i+1][0] = 1; // 1층부터 14층의 1호는 전부 1로 채운다.
        }

        while(n < N) {
            int a = Integer.parseInt(bf.readLine()); // 층수
            int b = Integer.parseInt(bf.readLine()); // 호수

            for(int j = 1; j <= a; j++) { // 층수
                for(int k = 1; k < b; k++) { // 호수 - 1
                    APT[j][k] = APT[j][k-1] + APT[j-1][k];
                }
            }

            System.out.println(APT[a][b-1]);
            n++;
        }

        bf.close();
    }
}
