package com.for_coding_test_book.Sorting;

public class problem6_1 {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            int min_index = i; // 가장 작은 원소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            // 스와프
            // 스와프란 특정한 리스트가 주어졌을 경우 두 변수의 위치를 변경하는 작업을 의미
            int temp = arr[i]; // 원래 값 임시저장
            arr[i] = arr[min_index]; // 위에서 바꾼 가장 인덱스의 값으로 변경
            arr[min_index] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
