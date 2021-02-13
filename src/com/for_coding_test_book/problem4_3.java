package com.for_coding_test_book;

import java.util.Scanner;

// Note 실습 4_3 왕실의 나이트 (내 풀이)
public class problem4_3 {
    public static void main(String[] args) {
        char[] ch = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        long startTime = System.currentTimeMillis();
        int num = 0;

        for (int i = 0; i < ch.length; i++) {
            if (input.charAt(0) == ch[i]) {
                num = i+1;
                break;
            }
        }

        int[] check1 = {2, -2};
        int[] check2 = {1, -1};
        int cnt = 0;

        for (int i = 0; i < 2; i++) {
            int x = num;
            int y = Integer.parseInt(String.valueOf(input.charAt(1)));

            int xs = x + check1[i];
            int ys = y + check1[i];

            if (xs <= 8 && xs > 0) {
                for(int k = 0; k < 2; k++) {
                    if (y + check2[k] <= 8 && y + check2[k] > 0) {
                        cnt++;
                    }
                }
            }

            if (ys <= 8 && ys > 0) {
                for(int k = 0; k < 2; k++) {
                    if (x + check2[k] <= 8 && x + check2[k] > 0) {
                        cnt++;
                    }
                }
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(cnt);
        System.out.print((endTime - startTime));
    }

    // 0.006초 걸림.
}
