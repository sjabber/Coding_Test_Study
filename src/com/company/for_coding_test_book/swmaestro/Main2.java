package com.company.for_coding_test_book.swmaestro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int index;

    public Node(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}

public class Main2 {

    public static boolean[] d = new boolean[10001]; // 도토리의 위치

    public static int n, m, e;

    public static int count = 0; // 먹은 땅콩의 개수
    public static int dist_up = 0; // 이동한 거리(위)
    public static int dist_down = 0; // 이동한 거리(아래)

    public static int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start));
        // 먹고자하는 땅콩개수에 도달하면 중단
        while (!q.isEmpty()) {
            Node node = q.poll();
            start = node.getIndex();

            if (d[start]) {
                d[start] = false;
                count += 1;
                if (count >= m) {
                    return dist_up + dist_down;
                }
                q.offer(new Node(start + 1));
                q.offer(new Node(start - 1));
            }

            // 위로 탐색
            if (start >= e) {
                int up = start + 1;
                if (up >= 10001) continue;
                if (d[up]) {
                    d[up] = false;
                    int distance = up - e;
                    dist_up = distance;
                    count += 1;
                    if (count >= m) {
                        return dist_up + dist_down;
                    }
                }
                q.offer(new Node(up));
            }

            // 아래로 탐색
            if (start <= e) {
                int dw = start - 1;
                if (dw < 1) continue;
                if (d[dw]) {
                    d[dw] = false;
                    int distance = e - dw;
                    dist_down = distance;
                    count += 1;
                    if (count >= m) {
                        return dist_up + dist_down;
                    }
                }
                q.offer(new Node(dw));
            }
        }

        return dist_up + dist_down;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 땅콩의 개수
        m = sc.nextInt(); // 먹으려는 땅콩 개수
        e = sc.nextInt(); // 소마의 위치

        // 땅콩의 위치를 입력받는다.
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            d[a] = true;
        }

        System.out.println(bfs(e));
    }
}
