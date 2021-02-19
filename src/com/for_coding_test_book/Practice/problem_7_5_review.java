package com.for_coding_test_book.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_7_5_review {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array1);

        int M = Integer.parseInt(br.readLine());
        int[] array2 = new int[M];

        Arrays.sort(array2);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (binarySearch(array1, array2[i], 0, N - 1) == 1) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }
        }
    }
}
