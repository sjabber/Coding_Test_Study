package com.for_coding_test_book.Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class problem6_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 기본 정렬 라이브러리 이용하여 내림차순 정렬을 진행
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
