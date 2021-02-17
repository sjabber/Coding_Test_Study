package com.for_coding_test_book.Sorting;

public class problem6_3 {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < n; i++) {
            // 인덱스 i 부터 1까지 감소하면서 반복하는 문법
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                // 우측의 값이 좌측 값보다 작은 경우 위치 바꿈 (자기보다 큰 데이터를 만나면 바꾼다)
                if (arr[j] < arr[j - 1]) {
                    // 스와프 (Swap)
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춘다.
                else break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
