package com.for_coding_test_book.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class obj {
    private int x;
    private int y;

    public obj(int x, int y) {
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

public class problem5_11_2 {

    public static int[][] graph = new int[201][201];

    public static int N; // 행 (x)
    public static int M; // 열 (y)

    // 상, 하, 좌, 우 의 순서로 진행한다.
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<obj> q = new LinkedList<>();
        q.offer(new obj(x, y));

        while (!q.isEmpty()) {
            obj obj = q.poll();
            x = obj.getX(); // 상, 하
            y = obj.getY(); // 좌, 우

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;

                if (graph[nx][ny] == 0) {
                    continue;
                } else if (graph[nx][ny] == 1) {
                    System.out.println("x : " + nx + ", y : " + ny);

                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new obj(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행 (x)
        M = sc.nextInt(); // 열 (y)
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1, 1);
        System.out.println(graph[N][M]);
    }
}
