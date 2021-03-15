package com.Dynamic_Programming;

import java.util.Scanner;

public class baekjoon_9184 {

    // 동적 프로그래밍을 하기 위한 변수 선언
    // a, b, c 가 20을 넘어갈 경우는 20으로 처리하기 위해 그 이상은 배열을 선언할 필요가 없다.
    public static int[][][] dp = new int[21][21][21];

    public static int w(int a, int b, int c) {

        // 들어온 값이 정상 범주이면서 메모이제이션 된 상태면 반환
        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        // a, b, c의 값이 음수인 경우
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) break;

            int result = w(a, b, c);
            System.out.println("w("+ a + ", " + b + ", " + c + ") = " + result);
        }
    }
}
