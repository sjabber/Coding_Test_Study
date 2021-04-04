package com;

import java.util.Scanner;

public class baekjoon_1018 {

    public static boolean[][] col;

    public static int result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로 길이
        int M = sc.nextInt(); // 가로 길이

        sc.nextLine(); // 버퍼 비우기 // 이거 깜빡해서 애먹음.

        col = new boolean[N][M];

        // 체스판의 모양을 입력받는다.
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();

            for (int j = 0; j < M; j++) {

                if (str.charAt(j) == 'W') {
                    col[i][j] = true;
                } else {
                    col[i][j] = false;
                }
            }
        }

        // 최고로 큰수를 넣어준다. (8 * 8)
        result = 64;

        // 가능한 모든 범위를 검토한다.
        for (int i = 0; i < N - 7; i++) { // 세로 검토범위
            for (int j = 0; j < M - 7; j++) { // 가로 검토범위
                find(i, j);
            }
        }

        System.out.print(result);
    }

    // 특정 범위를 검토하는 메서드
    public static void find(int a, int b) {

        int count = 0;

        // 맨 처음값 삽입
        boolean check = col[a][b];

        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {

                // 다음 것이 이전것과 같다면 카운트를 증가시킨다.
                if (check != col[i][j]) {
                    count++;
                }
                // 다음거랑 비교하기 위해 바꾼다.
                check = !check;
            }
            // 줄이 바뀌면 다시 바꾼다.
            check = !check;
        }

        // 처음 색을 기준으로 할 때 개수 => count
        // 반대색을 기준으로 할 때 개수 => 64 - count
        count = Math.min(count, 64 - count);

        // 최소값을 내보내야 하므로
        result = Math.min(result, count);
    }
}
