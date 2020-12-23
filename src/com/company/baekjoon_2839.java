package com.company;

import java.util.Scanner;

public class baekjoon_2839 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int check = num / 5;

        if(num % 5 == 0) {
            System.out.print(num/5);
            return;
        } else {
            for (int i = check; check > 0; i--) {
                int result = num - (i * 5);
                if (result % 3 == 0) {
                    System.out.print(result / 3 + i);
                    return;
                }
            }
        }

        if(num % 3 == 0) {
            System.out.print(num / 3);
        } else {
            System.out.print(-1);
        }

        return;
    }
}
