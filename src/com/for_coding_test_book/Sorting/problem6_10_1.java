package com.for_coding_test_book.Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 외우자. 체화 될때까지 계속 하는거다.
public class problem6_10_1 {

    // 선택정렬
    public static void sort_1(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min_index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    // 삽입정렬
    public static void sort_2(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            // 다음 인덱스로 하나하나 가면서 작은 값이 나오면 작은값보다 더 작은값 나오기 직전까지 쭉 보내서 삽입
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // 퀵정렬
    public static void sort_3(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while(left <= end && arr[left] <= arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        sort_3(arr, start, right - 1);
        sort_3(arr, right + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer[] arr = new Integer[num];

        for (int i = 0; i < arr.length; i++) {
            // arr[i] = sc.nextInt();
            arr[i] = sc.nextInt();
        }
        sc.close();

        /**

         sort_1(arr);
         sort_2(arr);
         sort_3(arr, 0, arr.length - 1);

         for (int i = arr.length - 1; i >= 0 ; i--) {
         System.out.print(arr[i] + " ");
         }

         **/

        // 기본 라이브러리를 활용할 경우
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
