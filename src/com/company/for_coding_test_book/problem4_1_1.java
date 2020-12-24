package com.company.for_coding_test_book;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class problem4_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int y = 1;

        Character[] cmd = {'L', 'R', 'U', 'D'};
        int[] x1 = {0, 0, -1, 1};
        int[] y1 = {-1, 1, 0, 0};

        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기
        String[] str = sc.nextLine().split(" ");

        for(int i = 0;  i < str.length; i++) {
            char plan = str[i].charAt(0);
            int sx = 0;
            int sy = 0;

            for (int j = 0; j < cmd.length; j++) {
                if(plan == cmd[j]) {
                    sx = x + x1[j];
                    sy = y + y1[j];
                }
            }

            if (sx > n || sy > n || sx < 1 || sy < 1) {
                continue;
            } else {
                x = sx;
                y = sy;
            }
        }

        System.out.println(x + " " + y);

    }
}
