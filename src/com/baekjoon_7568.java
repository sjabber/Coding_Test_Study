package com;

import java.util.Scanner;

public class baekjoon_7568 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력받을 사람의 수
        int N = sc.nextInt();

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt(); // x, 몸무게 입력
            arr[i][1] = sc.nextInt(); // y, 키 입력
        }

        for (int i = 0; i < N; i++) {
            int result = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    result++;
                }
            }
            System.out.print(result + " ");
        }

    }
}
