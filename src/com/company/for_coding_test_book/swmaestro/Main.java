package com.company.for_coding_test_book.swmaestro;

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        String str;
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        int a = 0, b = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                a += 1;
            } else {
                b += 1;
            }
        }

        if (a - b == 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

    }
}