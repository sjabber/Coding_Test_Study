package com.for_coding_test_book;

import java.util.Scanner;

// Note 4_3 정답 안보고 다시 풀어본 소스코드
public class problem4_4_1 {

    static int direction;

    public static void Left() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Note 매우 중요!! 이거때문에 오래걸림
        // Note 일반적인 수학에서의 x, y좌표 생각하면 안된다.
        // Note 먼저 그림을 그려보고 문제를 풀어보는걸 권장한다.
        // Note 일반적인 수학의 좌표와 반대로 동작한다.
        // ex) 위로 올라가는데 y값이 아닌 x값이 변하며 -1을 더해야한다..
        // 이처럼 매우 헷갈리므로 그림을 그려서 풀어보는 습관을 들여보자.

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int N = sc.nextInt();
        int M = sc.nextInt();

        int X = sc.nextInt();
        int Y = sc.nextInt();
        direction = sc.nextInt();
        int[][] RealMap = new int[N][M];
        int[][] ExeMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                RealMap[i][j] = sc.nextInt();
            }
        }

        //Note 가짜 맵을 만드는 이유는 가본 지역을
        // 1로 처리해서 길이 막힐경우 밀폐된 지역은 탐사를 못하기 때문임.
        // ex)
        // 1 1 1 1
        // 0 1 1 0
        // 1 1 1 1 이런 경우..
        ExeMap = RealMap;
        long start = System.currentTimeMillis();

        // 시뮬레이션 시작!!!
        ExeMap[X][Y] = 1;
        int result = 1;
        int turnTime = 0;

        while(true) {
            int xs, ys;

            Left(); // 반시계 방향으로 90도 회전 (북 -> 서)

            xs = X + dx[direction];
            ys = Y + dy[direction];
            if (ExeMap[xs][ys] != 1 && RealMap[xs][ys] != 1) {
                X = xs;
                Y = ys;
                ExeMap[X][Y] = 1;
                result++;
                turnTime = 0;
                continue; // 다음 회전방향으로 진행한다.
            } else turnTime += 1;

            if (turnTime == 4) { //동서남북 다 돌아봤는데 가봤거나 바다인경우..
                xs = X - dx[direction]; // 뒤로가기
                ys  = Y - dy[direction]; // 뒤로가기

                if (RealMap[xs][ys] == 0) { // 가봤지만 바다 아닌곳으로 나아감.
                    // Note 이 경우엔 가본 칸인데 바다는 아닌 칸이기 때문에
                    // Note result 가 +1 되지않고, ExeMap에도 값을 1로 변경하지 않음
                    // (이미 ExeMap 에는 1이 들어가있다..)
                    X = xs;
                    Y = ys;
                } else {
                    break;
                }

                turnTime = 0; // 다시 시작!
            }
        }
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(start - end);
    }
}
