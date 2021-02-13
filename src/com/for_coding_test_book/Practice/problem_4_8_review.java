package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class problem_4_8_review {

    public static void main(String[] args) {

        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        int x = position.charAt(0) - 'a';
        x++;

        int y = position.charAt(1) - '0';

        int result = 0;

        for (int i = 0; i < dx.length; i++) {
            int xs = x + dx[i];
            int ys = y + dy[i];

            if (xs > 8 || ys > 8 || xs < 1 || ys < 1) {
                continue;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}
