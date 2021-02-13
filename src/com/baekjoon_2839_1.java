package com;

import java.util.Scanner;

public class baekjoon_2839_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int check = 0; // 3으로 나눈 횟수

        while(true) {
            if(num % 5 == 0) {
                System.out.print(num/5 + check);
                break;
            } else if(num <= 0) {
                System.out.print(-1);
                break;
            } else {
                num -= 3;
                check++;
            }
        }
    }
}
