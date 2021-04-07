package com.DFS_BFS;

import java.util.*;

public class baekjoon_1260_2 {

    public static int N, M, V; // 각각 정점, 간선, 시작정점

    public static ArrayList<TreeMap<Integer, Integer>> graph;

    public static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new ArrayList<TreeMap<Integer, Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new TreeMap<Integer, Integer>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).put(b, a);
            graph.get(b).put(a, b);
        }

        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        TreeMap<Integer, Integer> tmap = graph.get(start);
        Set<Integer> set = tmap.keySet();
        Iterator<Integer> iter = set.iterator();

        // 재귀호출.
        while (iter.hasNext()) {
            int tmp = iter.next();
            if (!visited[tmp]) dfs(tmp);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            System.out.print(temp + " ");

            TreeMap<Integer, Integer> tmap = graph.get(temp);
            for (int val : tmap.keySet()) {
                if (!visited[val]) {
                    // 여기서 방문처리를 하지않으면 오류가 발생!!
                    // 사전에 방문처리(true)를 해야 여기라인을 안탄다.
                    visited[val] = true;
                    q.offer(val);
                }
            }
        }
    }
}

