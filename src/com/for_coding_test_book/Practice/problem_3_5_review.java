package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_3_5_review {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int i = 0;

        while(N != 1) {
            if (N % M == 0) {
                N /= M;
            } else {
                N -= 1;
            }
            i += 1;
        }

        System.out.println(i);
    }
}
