package com.company.for_coding_test_book;

import java.util.Scanner;

// Note 나동빈님 정답
public class problem4_2_1 {
    // 특정한 시각 안에 '3'이 포함되어 있는지의 여부
    private static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s % 10 == 3 || s / 10 == 3)
            return true;
            // % 10 -> 1의 자리수, / 10 -> 10의 자리수
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //시간 입력받기
        int H = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= H; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                   if(check(i, j, k)) cnt ++;
                }
            }
        }

        System.out.print(cnt);
    }
}
