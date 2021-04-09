package com;

import java.util.HashMap;
import java.util.Scanner;

public class baekjoon_3052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 10; i++) {
            int tmp = (sc.nextInt() % 42);
            hash.put(tmp, true);
        }

        System.out.print(hash.size());
    }
}
