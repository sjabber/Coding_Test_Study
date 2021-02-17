package com.for_coding_test_book.Sorting;

import java.util.Arrays;
import java.util.Scanner;

// 두 배열의 원소교체 문제
// 자바 정렬 라이브러리 사용

public class problem6_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // k번 만큼 배열 1번의 최소값과 배열 2번의 최대값을 변경해준다.
        for (int i = 1; i < K+1; i++) {
            if (arr1[i - 1] < arr2[N-i]) {
                arr1[i - 1] = arr2[N - i];
            } else break;
        }

//        // 나동빈님 코드
//        for (int i = 0; i < K; i++) {
//            // 1번 배열의 원소가 B의 원소보다 작은 경우
//            if (arr1[i] < arr2[N - (i + 1)]) {
//                // 두 원소를 교체한다.
//                int temp = arr1[i];
//                arr1[i] = arr2[N - (i + 1)];
//                arr2[N - (i + 1)] = temp;
//            }
//            // arr1의 원소가 arr2의 원소보다 크거나 같을 때, 반복문으로 탈출한다.
//            else break;
//        }

        // 배열 A의 모든 원소의 합을 출력한다.
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += arr1[i];
        }

        System.out.print(result);
    }
}
