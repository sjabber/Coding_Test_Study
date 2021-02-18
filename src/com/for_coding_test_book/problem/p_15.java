package com.for_coding_test_book.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_15 {

    // 각각 도시개수, 도로개수(단방향), 소요거리, 출발도시 를 담는 변수
    public static int N, M, K, X;

    // 각 노드별로 걸리는 거리정보를 담을 변수 (도시개수는 최대 3만이므로 3만 + 1 개만큼 생성)
    public static int[] d = new int[300001];

    // 노드들의 연결정보를 담을 그래프
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        br.close();

        // 시작지점 까지의 도착거리는 0으로 설정
         d[X] = 0;

        // BFS 수행한다.
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(X);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);

                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }
}
