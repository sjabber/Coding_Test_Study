package com;

import java.util.Scanner;

// Note 분명 해봤고 쉬운건데 기억안나서 남경이코드 참고함.
public class baekjoon_1924 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 달
        int D = sc.nextInt(); // 일

        int tmp = 0;

        for (int i = 1; i < M; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) tmp += 31;
            else if (i == 2) tmp += 28;
            else tmp += 30;
        }

        // 해당 월의 입력받은 일수를 더해준다.
        tmp += D;

        // 요일을 출력한다.
        if (tmp % 7 == 1) {
            System.out.print("MON");
        } else if (tmp % 7 == 2) {
            System.out.print("TUE");
        } else if (tmp % 7 == 3) {
            System.out.print("WED");
        } else if (tmp % 7 == 4) {
            System.out.print("THU");
        } else if (tmp % 7 == 5) {
            System.out.print("FRI");
        } else if (tmp % 7 == 6) {
            System.out.print("SAT");
        } else {
            System.out.print("SUN");
        }

    }
}
