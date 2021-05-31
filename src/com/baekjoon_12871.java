package com;

import java.util.Scanner;

public class baekjoon_12871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String temp1 = str1;
        String temp2 = str2;

        // 문자열 길이가 같다면
        if (str1.length() != str2.length()) {
            int len = LCM(str1.length(), str2.length());

            while (temp1.length() != len) {
                temp1 += str1;
            }

            while (temp2.length() != len) {
                temp2 += str2;
            }
        }

        if (temp1.equals(temp2)) System.out.println(1);
        else System.out.println(0);
    }

    // 최대 공약수
    public static int GCD(int a, int b) {

        while (b > 0) {
            // 스와핑
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    // 최소 공배수
    public static int LCM(int a, int b) {
        return (a*b)/GCD(a, b);
    }
}
