package com;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 백트레킹 문제
public class baekjoon_15651 {

    public static int[] arr;
    public static StringBuilder sb;


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1부터 N까지 자연수 중
        int M = sc.nextInt(); // 중복없이 M개를 고른다.

        sb = new StringBuilder();

        arr = new int[M];
        //visited = new boolean[N];
        dfs(N, M, 0);
        bw.flush();
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                String str = String.valueOf(val) + " ";
                bw.write(str);
            }
            bw.write("\n");
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
        }
    }
}

