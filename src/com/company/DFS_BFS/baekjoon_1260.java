package com.company.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Note 인접행렬 방식
public class baekjoon_1260 {

    public static int N, M, V;

    public static boolean[] visited;
    public static int[][] map;

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < N+1; i++) {
            if (map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        // 방문한 위치를 기록하기 위해 visited 는 필요하다.
        while (!q.isEmpty()) { // !q.isEmpty가 참일때까지만 한다는건 isEmpty()가 false 즉, 차있을때는 동작함
            int temp = q.poll();
            // 첫 번째 방문 위치를 뺀다.
            System.out.print(temp + " ");

            for (int k=1; k < N+1; k++) {
                if (map[temp][k] == 1 && !visited[k]) {
                    q.offer(k);
                    visited[k] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt(); // 탐색을 시작할 번호

        visited = new boolean[N+1];
        map = new int[N+1][N+1];

        //간선의 개수만큼 반복하여 입력받는다.
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1; // 연결되어 있음을 의미한다.
            map[b][a] = 1; // Note 행렬로 입력받는다.
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];

        bfs(V);
    }
}
