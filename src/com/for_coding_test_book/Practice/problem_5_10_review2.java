package com.for_coding_test_book.Practice;

import java.util.Scanner;

// 음료수 얼려먹기 문제
public class problem_5_10_review2 {

    public static int N, M;
    public static int[][] array;

    public static boolean dfs(int X, int Y) {

        if (X >= N || X < 0 || Y >= M || Y < 0) return false;

        if (array[X][Y] == 0) {
            array[X][Y] = 1;
            dfs(X - 1, Y);
            dfs(X + 1, Y);
            dfs(X, Y - 1);
            dfs(X, Y + 1);

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
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) result++;
            }
        }

        System.out.print(result);
    }
}
