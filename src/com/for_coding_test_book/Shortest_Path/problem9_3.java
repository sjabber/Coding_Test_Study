package com.for_coding_test_book.Shortest_Path;

import java.util.Arrays;
import java.util.Scanner;

// 플로이드 워셜 알고리즘
// 다익스트라 알고리즘 : 한 지점에서 다른 지점까지의 최단경로, 그리디 사용, 1차원 리스트, O(ElogN)의 시간복잡도
// 플로이드 워셜 알고리즘 : 모든 지점에서 다른 모든 지점까지의 최단경로, 동적 프로그래밍 사용, 2차원 리스트, O(N^3)의 시간복잡도

// 입력예시 :
//4
//7
//1 2 4
//1 4 6
//2 1 3
//2 3 7
//3 1 5
//3 4 4
//4 3 2
public class problem9_3 {

    public static final int INF = (int) 1e9; // 무한의 값 (10억)
    // 노드의 개수(N), 간선의 개수(M)
    // 노드의 개수는 최대 500개라고 가정
    public static int n, m;
    //2차원 배열(그래프 표현)을 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정함.
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행한다.
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (a == b) continue;
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
