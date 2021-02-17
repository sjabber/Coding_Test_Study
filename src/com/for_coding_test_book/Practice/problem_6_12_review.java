package com.for_coding_test_book.Practice;

// 02월 16일 정렬 알고리즘 공부
// 문제 : 첫 번째 줄에 N, K 가 공백으로 구분되어 입력
// 두번째 줄에 배열 A의 원소들이 공백으로 구분되어 입력된다. (모든 원소들은 10,000,000 보다 작은 자연수)
// 세번째 줄에 배열 B의 원소들이 공백으로 구분되어 입력된다. (위와 조건은 마찬가지)
// 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력한다.

import java.util.Scanner;

public class problem_6_12_review {

    public static void QuickSort(int[] arr, int start, int end) {

        // 종료조건, 배열의 크기가 1이면 재귀호출 중단됨.
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 작은수를 찾을 때까지 반복한다.
            while (left <= end && arr[left] < arr[pivot]) left++;

            // 피벗보다 큰 수를 찾을 때까지 반복한다.
            while (right > start && arr[right] >= arr[pivot]) right--;
            // 위의 과정을 끝마치면 교환한다.
            // 만약에 엇갈렸다면 작은 데이터와 피벗을 교체 (위에서 마땅히 찾은 값이 없는 경우)
            if (left > right) {
                // 스와프
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                // 이후 반복문 종료됨.
            } else {
                // 그렇지 않다면 작은 데이터와 큰 데이터를 교체
                // 스와프
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            // 분할 이후 왼쪽과 오른쪽에 대해서도 정렬을 수행한다.
            QuickSort(arr, start, right - 1);
            QuickSort(arr, right + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // 정렬 수행
        QuickSort(A, 0, N - 1);
        QuickSort(B, 0, N - 1);

        for (int i = 0; i < K; i++) {
            if (A[i] >= B[N - (i+1)]) {
                break;
            } else {
                // B의 큰 값들을 A의 작은값들과 교체
                int temp = A[i];
                A[i] = B[N - (i+1)];
                B[N - (i+1)] = temp;
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i];
        }
        System.out.print(result);
    }
}
