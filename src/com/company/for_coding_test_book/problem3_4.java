package com.company.for_coding_test_book;

import java.util.Scanner;

public class problem3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result1 = 0;

        // while(N == 1) 이라고 하니까 아예 안돌아버림
        // N이 1과 같을때 까지 반복한다. (x)
        // N이 1과 같으면 반복한다. (o)
        // Note while문이 돌아가는 조건을 잘못 이해하고 있었음.

        while(true) {
            if (N%K == 0) {
                N = N/K;
                result1++;
            } else if(N == 1) {
                break;
            } else {
                N--;
                result1 += 1;
            }
        }

        System.out.println(result1);
    }
}
