package com.for_coding_test_book;

import java.util.Scanner;

//Note 구현 문제
public class problem4_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] str = sc.nextLine().split(" ");
        int x = 1;
        int y = 1;

        for(int i = 0; i < str.length; i++) {
            int ny = 1;
            int nx = 1;

            if (str[i].equals("L")) {
                nx = x;
                ny = y - 1;
            } else if (str[i].equals("R")) {
                nx = x;
                ny = y + 1;
            } else if (str[i].equals("U")) {
                nx = x - 1;
                ny = y;
            } else if (str[i].equals("D")) {
                nx = x + 1;
                ny = y;
            }

            if (nx > N || nx == 0 || ny > N || ny == 0) continue;

            x = nx;
            y = ny;
        }

        System.out.print(x + " " + y);
    }
}
