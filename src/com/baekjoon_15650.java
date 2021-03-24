package com;

import java.util.Scanner;

// 중복제거가 핵심
public class baekjoon_15650 {

    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0, 0);
    }

    public static void dfs(int N, int M, int depth, int count) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = count; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
