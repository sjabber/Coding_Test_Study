package com.for_coding_test_book.Practice;

public class problem_3_1_review {

    public static void main(String[] args) {
        int n = 1260;
        int result = 0;
        int[] coin = {500, 100, 50, 10};

        for (int i = 0; i < coin.length; i++) {
            result += n / coin[i];
            n = n % coin[i];
        }

        System.out.println(result);
    }
}
