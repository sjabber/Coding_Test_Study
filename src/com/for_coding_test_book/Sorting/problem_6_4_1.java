package com.for_coding_test_book.Sorting;

public class problem_6_4_1 {

    public static void quickSorting(int[] arr, int start, int end) {
        if (start >= end) return;

        int marking = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            // 기준값(피벗)보다 큰 값이 나올 때까지 우로 이동
            while (left <= end && arr[left] <= arr[marking]) left++;

            // 기준값(피벗)보다 작은 값이 나올 때까지 좌로 이동
            while (right > start && arr[right] >= arr[marking]) right--;

            if(left > right) {
                // 좌, 우 인덱스가 엇갈린 경우
                int temp = arr[right];
                arr[right] = arr[marking];
                arr[marking] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }

            quickSorting(arr, start, right - 1);
            quickSorting(arr, right + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSorting(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
