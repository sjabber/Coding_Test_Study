package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_5_10_review {

    public static int N, M;
    public static int[][] array;

    public static boolean dfs(int x, int y) {

        if (x >= N || y >= M || x < 0 || y < 0) {
            return false;
        }

        if (array[x][y] == 0) {
            array[x][y] = 1;
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
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

        // 틀을 입력받는다.
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        // 정답을 담을 변수
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
