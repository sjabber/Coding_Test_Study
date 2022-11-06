package com.for_coding_test_book.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem15 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        int[] dist = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            graph.get(n).add(m);
        }

        dist[X] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);

                if (dist[nextNode] == -1) {
                    dist[nextNode] = dist[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        int result = 0;
        boolean check = false;
        for(int i = 0; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }
}
