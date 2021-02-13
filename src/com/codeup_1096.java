package com;

import java.util.Scanner;

public class codeup_1096 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];

        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            x = x - 1;
            y = y - 1;

            arr[x][y] = 1;
        }

        for (int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
