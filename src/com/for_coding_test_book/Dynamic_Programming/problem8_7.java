package com.for_coding_test_book.Dynamic_Programming;

import java.util.Scanner;

public class problem8_7 {

    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 n 입력받기 
        int n = sc.nextInt();

        // 다이나믹 프로그래밍 진행 (보텀업)
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        // 계산된 결과 출력
        System.out.println(d[n]);
    }
}
