package com.for_coding_test_book.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node3 {
    private int x;
    private int y;

    public Node3(int x, int y) {
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

// 얼음 얼려먹기 문제 DFS가 아닌 BFS로 풀기
public class problem5_10_2 {

    public static int rows, columns;
    public static int[][] graph = new int[1000][1000];

    // 상, 하, 좌, 우
    public static int dx[] = {-1, 1, 0, 0}; //상, 하
    public static int dy[] = {0, 0, -1, 1}; //좌, 우

    public static int result;

    public static boolean bfs(int x, int y) {
        Queue<Node3> q = new LinkedList<>();
        q.offer(new Node3(x, y));

        boolean check = false;

        while(!q.isEmpty()) {
            Node3 node = q.poll();
            x = node.getX();
            y = node.getY();

            if(graph[x][y] == 0) {
                graph[x][y] = 1;
                check = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) continue;

                    if (graph[nx][ny] == 1) {
                        continue;
                    } else {
                        q.offer(new Node3(nx, ny));
                    }
                }

            }
        }

        return check;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt(); // y 크기
        columns = sc.nextInt(); // x 크기
        sc.nextLine();

        for (int i = 0; i < rows; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < columns; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(bfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
