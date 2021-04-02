package com;

import java.util.Scanner;

public class baekjoon_2018 {

    // 등차수열을 떠올려야 한다. 등차수열의 합 K를 편의상 tmp 라고 하자.
    // tmp = n * (n + 1) / 2 이다.
    // (a + 1) + (a + 2) + (a + 3) ... + (a + n) = N
    // (a * n) + tmp = N 라고 할 수 있다
    // N - tmp = a * n
    // (N - tmp) / n = a 이다.
    // 즉 (N - tmp) / n 가 나누어 떨어지면 a가 성립한다.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = 1;
        int result = 0;

        while(true) {
            // 등차수열 공식 적용
            int tmp = (num * (num + 1)) / 2;

            if (tmp > N) break;

            // Note 위의 설명이 여기에 적용된다.
            if ((N - tmp) % num == 0) {
                result++;
            }

            num++;
        }

        System.out.print(result);
    }
}
