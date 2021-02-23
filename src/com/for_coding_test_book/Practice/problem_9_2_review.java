package com.for_coding_test_book.Practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 개선된 다익스트라 알고리즘
// 입력예시
//6 11
//1
//1 2 2
//1 3 5
//1 4 1
//2 3 3
//2 4 2
//3 2 3
//3 6 5
//4 3 3
//4 5 1
//5 3 1
//5 6 2
// 정답 -> 0 2 3 1 2 4 순으로 출력
class Nodes implements Comparable<Nodes> {

    private int index;
    private int distance;

    public Nodes(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은게 우선순위를 가지도록 설정한다.
    @Override
    public int compareTo(Nodes other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class problem_9_2_review {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Nodes>> graph = new ArrayList<ArrayList<Nodes>>();
    // 최단거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        // 우선순위 큐
        PriorityQueue<Nodes> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입한다.
        pq.offer(new Nodes(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Nodes nodes = pq.poll();
            int dist = nodes.getDistance(); // 현재 노드 까지의 비용
            int now = nodes.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧을 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Nodes(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수
        start = sc.nextInt(); // 시작 노드

        // 그래프 초기화
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<Nodes>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Nodes(b, c));
        }

        // 최단거리 테이블을 모두 무한으로 초기화한다.
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단거리를 출력한다.
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
