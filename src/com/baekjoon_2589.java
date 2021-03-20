package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_num2 {
    private int index;
    private int distance;
    private int count;

    public Node_num2(int index, int distance, int count) {
        this.index = index;
        this.distance = distance;
        this.count = count;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getCount() {
        return this.count;
    }
}

public class baekjoon_2589 {
    public static int N, M;
    public static boolean[][] visisted = new boolean[51][51];
    public static char[][] arr = new char[51][51];

    // 이동할 방향 네가지를 정의한다.
    public static int dx[] = {-1, 1, 0, 0}; // 상 하
    public static int dy[] = {0, 0, -1, 1}; // 좌 우

    public static int bfs(int x, int y, int cnt) {
        int result = 0;
        visisted[x][y] = true;

        // 큐 구현을 위한 큐 라이브러리
        Queue<Node_num2> q = new LinkedList<>();
        q.offer(new Node_num2(x, y, cnt));

        // 큐가 빌 때까지 반복한다.
        while(!q.isEmpty()) {
            Node_num2 node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            cnt = node.getCount();
            // 현재 위치에서 4가지 방향으로 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 공간을 벗어난 경우 무시한다.
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 바다이거나 방문한 경우
                if (visisted[nx][ny] || arr[nx][ny] == 'W') continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리를 기록한다.
                if (!visisted[nx][ny] && arr[nx][ny] == 'L') {
                    visisted[nx][ny] = true;
                    q.offer(new Node_num2(nx, ny, cnt+1));
                    result = Math.max(result, cnt+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 섬의 지도를 입력받는다.
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        br.close();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    visisted = new boolean[51][51];
                    result = Math.max(bfs(i, j, 0), result);
                }
            }
        }

        System.out.print(result);
    }
}
