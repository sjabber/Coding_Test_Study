package com.for_coding_test_book.Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node22 {

    private int X, Y;

    public Node22(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }
}

public class problem_5_11_review {

    // 상 하 좌 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N, M;
    public static int[][] array = new int[201][201];

    public static int bfs(int x, int y) {

        Queue<Node22> q = new LinkedList<>();
//        Node22 node22 = new Node22(x, y);
//        q.offer(node22);
        q.offer(new Node22(x, y));

        while (!q.isEmpty()) {
            Node22 nd = q.poll();
            x = nd.getX();
            y = nd.getY();

            for (int i = 0; i < 4; i++) {
                int xs = x + dx[i];
                int ys = y + dy[i];

                // 맵의 범위를 벗어날경우 무시한다.
                if (xs >= N || ys >= M || xs < 0 || ys < 0) {
                    continue;
                }
                // 벽을 만난 경우 무시한다.
                if (array[xs][ys] == 0) {
                    continue;
                } else if (array[xs][ys] == 1) {
                    // 이전 칸 값에 +1을 한다.
                    array[xs][ys] = array[x][y] + 1;
                    q.offer(new Node22(xs, ys));
                }

            }

        }

        return array[N-1][M-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        // 그래프를 입력받는다.
        for (int i = 0; i < N; i ++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }
}
