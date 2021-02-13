package com.for_coding_test_book.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
    private int X, Y;

    public node(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

}

public class problem5_11_1 {
    public static int[][] graph;
    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0}; // Note 상, 하,  important 좌, 우
    public static int[] dy = {0, 0, -1, 1}; // important 상, 하 Note 좌, 우

    public static void bfs(int x, int y) {
        int xx, yy;

        Queue<node> q = new LinkedList<>();
        q.offer(new node(x, y));

        while(!q.isEmpty()) {
            node nd = q.poll();
            x = nd.getX();
            y = nd.getY();

            for (int i = 0; i < 4; i++) {
                xx = x + dx[i];
                yy = y + dy[i];

                // 그래프의 범위를 벗어나면 넘긴다.
                if (xx > N-1 || xx < 0 || yy > M-1 || yy < 0) continue;

                // 벽이 존재하면 넘긴다.
                if (graph[xx][yy] == 0) continue;

                if (graph[xx][yy] == 1) {
                    graph[xx][yy] = graph[x][y] + 1;
                    q.offer(new node(xx, yy));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.print(graph[N-1][M-1]);
    }
}
