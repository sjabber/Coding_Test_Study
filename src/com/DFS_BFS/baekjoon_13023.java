package com.DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_13023 {

    public static ArrayList<Integer>[] node;
    public static boolean[] visited;
    public static boolean check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        node = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            node[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            node[a].add(b);
            node[b].add(a);
        }

        // node.length == N
        for (int i = 0; i < node.length; i++) {
            dfs(i, 0);

            if (check) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
        return;
    }

    public static void dfs(int num, int depth) {
        if (depth == 4) {
            check = true;
            return;
        }

        for (int i = 0; i < node[num].size(); i++) {
            if (!visited[node[num].get(i)]) {
                visited[num] = true;
                dfs(node[num].get(i), depth + 1);
                if (check) return;
                visited[num] = false;
            }
        }
    }
}
