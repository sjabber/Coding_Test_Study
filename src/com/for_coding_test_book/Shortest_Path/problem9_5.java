package com.for_coding_test_book.Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node_5 implements Comparable<Node_5> {

    private int index;
    private int distance;

    Node_5(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }

    // 거리(비용)가 짧은게 우선순위를 가질 수 있도록 설정한다.
    @Override
    public int compareTo(Node_5 other) {
        if (this.distance < other.distance) {
            return -1;
        }

        return 1;
    }
}

public class problem9_5 {

    public static int INF = (int) 1e9; // 무한의 값을 설정한다.

    public static int n, m, c; //도시개수 n, 통로개수 m, 메세지 보내려는 도시 c

    public static ArrayList<ArrayList<Node_5>> graph = new ArrayList<ArrayList<Node_5>>(); //도시의 연결정보를 저장할 변수

    public static int[] d; // 도시의 개수

    public static void dijkstra(int start) {
        PriorityQueue<Node_5> pq = new PriorityQueue<Node_5>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입한다.
        pq.offer(new Node_5(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보를 꺼낸다.
            Node_5 nd = pq.poll();
            int dist = nd.getDistance(); // 현재 노드까지의 비용
            int now = nd.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시한다.
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i=0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐, 다른 노드로 이동하는 거리가 더 짧을 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node_5(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 도시의 개수
        m = sc.nextInt(); // 통로의 개수
        c = sc.nextInt(); // 메세지 보내려는 도시

        d = new int[n+1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node_5>());
        }

        // 모든 간선의 정보를 입력받는다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node_5(b, c));
        }

        // 최단거리 테이블 무한의 값으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(c);

        // 메시지를 받는 도시의 총 개수와 걸리는 시간을 출력한다.
        int count = 0;
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count++;
            }

            maxTime = Math.max(d[i], maxTime);
        }

        System.out.print(count-1 + " " + maxTime);
    }
}
