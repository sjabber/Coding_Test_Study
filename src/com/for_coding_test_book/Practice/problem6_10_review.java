package com.for_coding_test_book.Practice;

import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class problem6_10_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer[] arr = new Integer[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
