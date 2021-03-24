package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2468 {

    public static int[][] arr;
    public static boolean[][] visited;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int maximum = 0;
        for (int i = 1; i < 101; i++) {
            int result = 0;
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (dfs(j, k, i)) {
                        result++;
                    }
                }
            }
            maximum = Math.max(result, maximum);
        }

        System.out.print(maximum);

    }

    public static boolean dfs(int x, int y, int num) {

        if (x < 0 || x >= N || y < 0 || y >= N) return false;

        if (arr[x][y] >= num && !visited[x][y]) {

            visited[x][y] = true;
            dfs(x - 1, y, num); // 상
            dfs(x + 1, y, num); // 하
            dfs(x, y - 1, num); // 좌
            dfs(x, y + 1, num); // 우
            return true;
        }

        return false;
    }
}
