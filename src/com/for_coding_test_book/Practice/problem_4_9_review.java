package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_4_9_review {

    public static int direc;

    // 북 : 0
    // 동 : 1
    // 남 : 2
    // 서 : 3
    public static void turn_Left() {
        direc -= 1;
        if (direc == -1) {
            direc = 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 4 입력
        int M = sc.nextInt(); // 4 입력

        int x = sc.nextInt(); // 1 입력
        int y = sc.nextInt(); // 1 입력
        direc = sc.nextInt();

        // 북, 동, 남, 서
        // x - 1, y + 1, x + 1, y - 1
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] array = new int[N][M];
        int[][] real_map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j ++) {
                // 지도를 입력받는다.
                real_map[i][j] = sc.nextInt();
            }
        }


        // 방향 전환을 할때마다 스택이 쌓임, 4가 되면 점검에 들어간다.
        int stack = 0;

        // 시작지점은 하나 올리고 시작한다.
        int result = 1; // 정답을 담을 변수
        array[x][y] = 1;
        while (true) {

            turn_Left();
            //surrogate x, y
            int sx = x + dx[direc];
            int sy = y + dy[direc];

            // 범위를 넘어설 경우 건너 뛰도록 한다.
            if (sx >= N || sy >= M || sx < 0 || sy < 0) {
                continue;
            }

            if (array[sx][sy] == 0 && real_map[sx][sy] == 0) {
                // 해당 좌표가 가본적이 없는 경우
                array[sx][sy] = 1;
                x = sx;
                y = sy;
                stack = 0;
                result++;
                continue;
            } else {
                // 해당 좌표가 가본적이 있는경우
                stack++;
            }

            // 4방향을 전부 돌아본 경우
            if (stack == 4) {
                sx = x - dx[direc];
                sy = y - dy[direc];

                if (real_map[sx][sy] == 0) {
                    x = sx;
                    y = sy;
                } else {
                    // 뒤가 바다로 막혀있는 경우
                    break;
                }
                stack = 0;
            }
        }

        System.out.println(result);
    }
}
