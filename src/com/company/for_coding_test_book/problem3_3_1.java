package com.company.for_coding_test_book;

import java.util.Scanner;

public class problem3_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int min_value = 10001; // 행마다 min_value = 10001로 갱신한다.
            for (int j = 0; j < m; j++) {
                int temp = sc.nextInt();
                // 각각의 행 중에서 최소값을 대입한다.
                min_value = Math.min(temp, min_value);
            }

            //이전 행의 최소값과 해당 행의 최소값 중에서 더 큰거 고른다.
            result = Math.max(min_value, result);
        }

        System.out.println(result);
    }
}
