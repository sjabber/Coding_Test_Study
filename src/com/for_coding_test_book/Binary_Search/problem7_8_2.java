package com.for_coding_test_book.Binary_Search;

import java.util.Scanner;

// Note 파라메트릭 서치
// 최적화 문제를 결정 문제(예, 아니오로 답하는 문제)로 바꾸어 해결하는 기법
// 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제
// ex) 범위내에서 조건을 만족하는 가장 큰 값을 찾으라는 최적화 문제 => 이진 탐색
public class problem7_8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;

        // 이진 탐색 수행 (반복적)
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2; // 떡 자를 높이 위치
            for (int i = 0; i < n; i++) {
                // 잘랐을 경우 떡의 양 계산
                if (arr[i] > mid) total += arr[i] - mid;
            }
            if (total < m) { // 떡 크기가 모자랄 경우 (mid 좌로 이동)
                end = mid - 1;
            } else { // 떡 크기가 클 경우 (mid 우로 이동)
                result = mid; // 최대한 mid 가 클 경우 (떡을 덜 자를 수록) 정답이므로 여기 높이를 기록해나간다.
                start = mid + 1;
            }
        }

    }
}
