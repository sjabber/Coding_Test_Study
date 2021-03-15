package com;

import java.util.Scanner;

// 백트레킹 문제
public class baekjoon_15649 {

    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1부터 N까지 자연수 중
        int M = sc.nextInt(); // 중복없이 M개를 고른다.

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
