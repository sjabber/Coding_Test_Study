package com.company.for_coding_test_book.DFS;
// Note 인접행렬

public class Adjacency_Matrix {

    public static final int INF = 999999999;
    // 인접행렬에서 연결되지 않은 노드끼리는
    // 무한의 비용이라 작성한다.
    // 위와같이 큰 값으로 초기화하는 경우가 많음.

    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String[] args) {
        //그래프 출력
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
