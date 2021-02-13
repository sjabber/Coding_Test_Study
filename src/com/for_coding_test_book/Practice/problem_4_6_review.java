package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_4_6_review {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Character[] direct = {'L', 'R', 'U', 'D'};
        int[] X = {0, 0, -1, 1};
        int[] Y = {-1, 1, 0, 0};
        int x = 1;
        int y = 1;

        int N = sc.nextInt();

        sc.nextLine();
        String[] input = sc.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            char cmd = input[i].charAt(0);
            int xs = x;
            int ys = y;

            for (int k = 0; k < direct.length; k++) {
                if (cmd == direct[k]) {
                    xs += X[k];
                    ys += Y[k];
                }
            }

            if (xs > N || ys > N || xs < 1 || ys < 1) {
                continue;
            } else {
                x = xs;
                y = ys;
            }
        }

        System.out.println(x + " " + y);
    }
}
