package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_4_7_review {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;
        String str;

        for (int i = 0; i < N+1; i++) {
            String H = String.valueOf(i);
            for (int j = 0; j < 60; j++) {
                String M = String.valueOf(j);
                for (int k = 0; k < 60; k++) {
                    String S = String.valueOf(k);
                    str = H + M + S;
                    if (str.contains("3")) result++;
                }
            }
        }

        System.out.println(result);
    }
}
