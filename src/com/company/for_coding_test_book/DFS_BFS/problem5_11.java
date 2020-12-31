package com.company.for_coding_test_book.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2 {
    private int index;
    private int distance;

    public Node2(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class problem5_11 {
    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향을 정의한다. (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // 큐 구현을 위해 큐 라이브러리 사용
        Queue<Node2> q = new LinkedList<>();
        q.offer(new Node2(x, y));
        // 큐가 빌 빌 때까지 반복한다.
        while(!q.isEmpty()) {
            Node2 node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node2(nx, ny)); // Node2(nx, ny)에 대한 참조 즉, 포인터값이 담긴다.
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보를 입력받는다.
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int k = 0; k < m; k++) {
                graph[i][k] = str.charAt(k) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
