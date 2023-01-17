package com.for_coding_test_book.Practice;

import java.util.Scanner;

public class newLineTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int num = sc.nextInt();

        System.out.print("문자열1 입력 : ");
        String str1 = sc.next();

        // nextLine()은 이전에 next()가 남긴 newline(\n) 때문에 바로 nextLine()을 하면 줄바꿈해버리고 끝난다.
         sc.nextLine();

        System.out.print("문자열2 입력 : ");
        String str2 = sc.nextLine();

        System.out.println();

        System.out.println("숫자 : " + num);
        System.out.println("문자1 : " + str1);
        System.out.println("문자2 : " + str2);
    }
}
