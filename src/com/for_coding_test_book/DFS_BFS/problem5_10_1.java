package com.for_coding_test_book.DFS_BFS;

import java.util.Scanner;

public class problem5_10_1 {

    public static int[][] array;
    public static int N, M;

    public static boolean dfs(int x, int y) {

        if (x >= N || x < 0 || y >= M || y < 0) {
            return false;
        }

        if (array[x][y] == 0) {
            array[x][y] = 1;

            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = str.charAt(j) - '0';
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.print(result);
    }
}
