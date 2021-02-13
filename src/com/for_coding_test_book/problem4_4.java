package com.for_coding_test_book;

import java.util.Scanner;

// Note 왼쪽으로 회전하는 문제때문에 답을 보고 구현함.
// Note 이거 틀린답임... 바다맵, 가본맵 따로 구현해야함.
public class problem4_4 {
    public static int direction;

    private static void TurnLeft() {
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }

    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // 지도 사이즈

        int x = sc.nextInt();
        int y = sc.nextInt(); // 위치

        direction = sc.nextInt(); // 방향

        int[][] map = new int[N][M]; // 지도 정의

        // 지도 입력받기
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                map[i][k] = sc.nextInt();
            }
        }

        // 시작지점 체크
        map[x][y] = 1;

        // 첫 시작지점 체크로 1부터 시작
        int result = 1;

        // Note 탐색 시작
        Loop :
        while(true) {
            int xs = 0, ys = 0;
            for (int i = 0; i < 4; i++) {
                TurnLeft();
                xs = x + dx[direction];
                ys = y + dy[direction];
                if (map[xs][ys] != 1) {
                    x = xs;
                    y = ys;
                    map[x][y] = 1;
                    result++;
                    i = 0;
                }
            }

            if (direction == 0 && map[x][y-1] != 1) {
                y -= 1;
                result++;
            } else if (direction == 1 && map[x-1][y] != 1) {
                x -= 1;
                result++;
            } else if (direction == 2 && map[x][y+1] != 1) {
                y += 1;
                result++;
            } else if (direction == 3 && map[x+1][y] != 1) {
                x += 1;
                result++;
            } else {
                break Loop;
            }
        }

        System.out.print(result);
    }
}
