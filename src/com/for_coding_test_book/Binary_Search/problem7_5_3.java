package com.for_coding_test_book.Binary_Search;

import java.util.Arrays;
import java.util.Scanner;

public class problem7_5_3 {

    public static boolean BinarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {
                return true;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] store = new int[N];
        for (int i = 0; i < N; i++) {
            store[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] guest = new int[M];
        for (int i = 0; i < M; i++) {
            guest[i] = sc.nextInt();
        }

        Arrays.sort(store);

        for (int i = 0; i < M; i++) {
            if (BinarySearch(store, guest[i], 0, N-1)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
