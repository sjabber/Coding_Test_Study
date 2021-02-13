package com.DFS_BFS;

import java.io.*;
import java.util.*;

public class baekjoon_1260_1 {

    public static boolean[] visited;
    public static ArrayList<TreeMap<Integer, Integer>> graph;
    public static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer str = new StringTokenizer(s, " ");
        N = Integer.parseInt(str.nextToken()); // 노드 개수
        M = Integer.parseInt(str.nextToken()); // 간선개수
        V = Integer.parseInt(str.nextToken()); // 탐색을 시작할 노드번호

        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new TreeMap<Integer, Integer>());
        }

        for (int i = 0; i < M; i++) {
            String[] str2;
            str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            graph.get(a).put(b, a); // get(a).put(a, b) -> 트리 value 값이 중복되어 하나만 저장됨.
            graph.get(b).put(a, b);
        }
        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);

        br.close();
    }

    public static void dfs(int start) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited[start] = true;
        bw.write(start + " ");
        bw.flush();
        //System.out.print(start + " ");
        TreeMap<Integer, Integer> trm = graph.get(start);

        for (int i : trm.keySet()) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int tmp = q.poll();
            visited[tmp] = true;
            System.out.print(tmp + " ");
            TreeMap<Integer, Integer> map = graph.get(tmp);

            for (int i : map.keySet()) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
