package com.sorting;

// 선택정렬 알고리즘
// 선택정렬의 경우 자바에서 기본적으로 제공하고 있다. -> Arrays.sort() 메소드

import java.util.Scanner;

class baekjoon_2750_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // select sort
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for(int val : arr) {
            System.out.println(val);
        }

    }
}
