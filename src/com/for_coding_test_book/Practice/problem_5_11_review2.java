package com.for_coding_test_book.Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2 {
    private int x, y;

    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class problem_5_11_review2 {

    public static int N, M;
    public static int[][] array = new int[201][201];

    // 상 하 좌 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 너비우선 탐색
    public static int bfs(int x, int y) {

        Queue<Node2> Q = new LinkedList<>();
        Q.offer(new Node2(x, y));

        // 큐가 비게되면 종료된다.
        while (!Q.isEmpty()) {
            Node2 node = Q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int xs = x + dx[i];
                int ys = y + dy[i];

                if (xs >= N || xs < 0 || ys >= M || ys < 0) {
                    continue;
                }

                if (array[xs][ys] == 0) {
                    continue;
                } else if (array[xs][ys] == 1) {
                    array[xs][ys] = array[x][y] + 1;
                    Q.offer(new Node2(xs, ys));
                }

            }
        }

        return array[N-1][M-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.print(bfs(0, 0));
    }
}
