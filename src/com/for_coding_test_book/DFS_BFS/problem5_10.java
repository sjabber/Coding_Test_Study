package com.for_coding_test_book.DFS_BFS;

import java.util.Scanner;

public class problem5_10 {

    public static int n, m;
    public static int[][] graph = new int[1001][1001];

    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드를 방문처리한다.
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            // Note 이것이 dfs 의 핵심이라고 할 수 있다.
            dfs(x - 1, y); // 상
            dfs(x + 1, y); // 하
            dfs(x, y - 1); // 좌
            dfs(x, y + 1); // 우
            return true;
       }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받는다.
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우고

        // 2차원 리스트의 맵 정보 입력받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                 graph[i][j] = str.charAt(j) - '0';
                 //'0' -> 문자열을 숫자로 변경하기 위함
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
