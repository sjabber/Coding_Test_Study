package com.for_coding_test_book.Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 나동빈 9_4 미래도시 문제 (다시 풀어보기..!)
class Node_9 {

    private int index;
    private int distance;

    public void Node_9(int index, int distance) {
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

public class problem9_4 {

    public static final int INF = (int) 1e9;

    public static int N, M, X, K;

    public static int[][] graph = new int[101][101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

       // 자기 자신에 대한 경로비용은 0으로 초기화
       for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

       // 각 간선에 대한 정보를 입력받아 그 값으로 초기화한다.
        for (int i = 0; i < M; i++) {
            // A와 B가 서로에게 가는 비용은 1이라고 설정한다.
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        X = sc.nextInt();
        K = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력한다.
        int distance = graph[1][K] + graph[K][X];

        // 도달할 수 없는 경우 -1을 출력한다.
        if (distance == INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}
