package com.for_coding_test_book.Practice;

import java.util.Scanner;

// 대표적인 동적 프로그래밍(Dynamic Programming) 문제
public class problem_8_5_review {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int result = 0;
        while (X > 1) {
            if (X % 5 == 0) {
                X = X / 5;
                result++;
            } else if (X % 3 == 0) {
                X = X / 3;
                result++;
            } else if (X % 2 == 0) {
                X = X / 2;
                result++;
            } else {
                X -= 1;
                result++;
            }

            if (X == 1) {
                break;
            }
        }
        System.out.println(result);
    }
}
