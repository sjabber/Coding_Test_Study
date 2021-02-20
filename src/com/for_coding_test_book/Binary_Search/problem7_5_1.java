package com.for_coding_test_book.Binary_Search;

import java.util.Scanner;

// 문제 7_5 계수정렬로 풀기
public class problem7_5_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] = 1;
        }

        // M(손님이 찾고자하는 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나하나 확인한다.
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인한다.
            if (arr[targets[i]] == 1) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }
        }
    }
}
