package com;

import java.util.Scanner;

public class baekjoon_10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.print(Fibonacci(num));
    }

    private static int Fibonacci(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 0){
            return 0;
        } else {
            return Fibonacci(num-1) + Fibonacci(num-2);
        }
    }
}
