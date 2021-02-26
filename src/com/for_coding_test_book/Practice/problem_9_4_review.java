package com.for_coding_test_book.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class problem_9_4_review {

    public static int INF = (int) 1e9; // 무한의 값

    public static int N, M, X, K; // 회사개수 N, 경로개수 M, 경유지 X, 도착지 K

    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 회사(노드) 개수
        M = sc.nextInt(); // 경로(간선) 개수
        graph = new int[N+1][N+1];

        // 노드정보를 담은 변수를 무한으로 채운다.
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        X = sc.nextInt();
        K = sc.nextInt();

        sc.close(); // 입력 종료

        // 자기 자신으로 가는 경로는 0으로 비용처리함.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 플로이드 워셜 알고리즘 수행
        // O(N^3)의 시간복잡도, 점화식 -> Dab = min(Dab, Dak + Dkb)
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 정답을 출력한다.
        int result = graph[1][K] + graph[K][X];

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
