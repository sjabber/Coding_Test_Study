package com;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_11404_1 {

    // 무한의 값 (10억)
    public static final int INF = (int) 1e9;

    // 도시 개수 (N), 버스 노선 개수 (M)
    public static int N, M;

    // 2차원 배열(그래프 표현)을 만들기
    public static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1]; // 2차원 배열(도시별 노선정보) 초기화

        // 해당 노선들의 정보를 전부 무한으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        StringTokenizer st;

        // 각 노선들에 대한 정보를 입력받는다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (graph[a][b] > c) {
                graph[a][b] = c;
            }
        }

        br.close();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행한다.
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (a == b || a == k || b == k) continue;
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력한다.
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)라고 출력한다.
                if (graph[a][b] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(graph[a][b] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
