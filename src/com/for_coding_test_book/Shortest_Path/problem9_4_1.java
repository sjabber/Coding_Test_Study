package com.for_coding_test_book.Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem9_4_1 {

    public static final int INF = (int) 1e9;

    public static int N, M, X, K; // 노드, 간선, 목적지, 경유지지

    public static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에 대한 경로값은 0으로 초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력받아 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A][B] = 1;
            graph[B][A] = 1;
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력한다.
        int distance = graph[1][K] + graph[K][X];

        if (distance >= INF) System.out.println(-1);
        else System.out.println(distance);
    }
}
