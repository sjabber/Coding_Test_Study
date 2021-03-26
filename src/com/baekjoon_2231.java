package com;

import java.util.Scanner;

public class baekjoon_2231 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 방법 1
        //System.out.print(Decomposition(N));

        // 방법 2 (개선된 메서드 사용)
        System.out.print(Decomposition2(N));
    }

    public static int Decomposition(int N) {

        for (int i = 0; i < N; i++) {
            // i / 10
            int tmp = i; // i 의 값을 임시로 담을 변수
            int result = 0;

            // i 값이 0이 될 때 까지 반복한다.
            while (tmp != 0) {
                // i의 각 자리수 값을 구하기 위해 10으로 나눈 나머지를 구한다음
                // 10으로 나눈값으로 갱신.
                result += tmp % 10;
                tmp /= 10;
            }
            // N이 3의 자리수 일 경우
            // N = x + x1 + x2 + x3 이므로 x 값을 더해준다.
            result += i;

            if (result == N) {
                return i;
            }

        }

        // 분해합이 없는 경우
        return  0;
    }

    public static int Decomposition2(int N) {

        String str = String.valueOf(N);
        int n = str.length(); // 자리수를구한다.

        // N이 3의 자리수 일 경우
        // N = x + x1 + x2 + x3 이다. (구하고자 하는 값은 x)
        // N - (x1 + x2 + x3) = x 이며 x1, x2, x3 각각의 최대값은 9이다.
        // 즉 자리수가 n일 경우, 분해합을 성립시키는 최소 값 조건은 N - (9 * n) 이 된다.
        for (int i = N - (9 * n); i < N; i++) {
            // i / 10
            int tmp = i; // i 의 값을 임시로 담을 변수
            int result = 0;

            // i 값이 0이 될 때 까지 반복한다.
            while (tmp != 0) {
                // i의 각 자리수 값을 구하기 위해 10으로 나눈 나머지를 구한다음
                // 10으로 나눈값으로 갱신.
                result += tmp % 10;
                tmp /= 10;
            }
            // N이 3의 자리수 일 경우
            // N = x + x1 + x2 + x3 이므로 x 값을 더해준다.
            result += i;

            if (result == N) {
                return i;
            }

        }

        // 분해합이 없는 경우
        return  0;
    }
}
