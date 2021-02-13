package com.for_coding_test_book;

import java.util.Scanner;

// Note 구현문제
public class problem4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int result = 0;
        String str;

        for (int i = 0; i < H+1; i++) {
            String strH = String.valueOf(i);
            for(int j = 0; j < 60; j++) {
                String strM = String.valueOf(j);
                for(int k = 0; k < 60; k++) {
                    String strS = String.valueOf(k);
                    str = strH + strM + strS;
                    if(str.contains("3")) {
                        result ++;
                    }
                }
            }
        }
        System.out.println(result);

    }
}
