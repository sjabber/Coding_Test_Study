package com.for_coding_test_book.Practice;

import java.util.Scanner;

// 02월 16일
// 계수정렬 복습
public class problem_6_6_review {

    private static int Max_Value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Max_Value = sc.nextInt();

        int[] arr = new int[N];
        int[] count = new int[Max_Value + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            count[arr[i]] += 1;
        }

        // 해당하는 값이 반복적으로 출력된다.
        for (int i = 0; i <= Max_Value; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
