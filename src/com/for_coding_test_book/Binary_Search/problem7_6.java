package com.for_coding_test_book.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem7_6  {
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int result = 0;
        while(start <= end) {
            int amount = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) amount += arr[i] - mid;
            }
            // 떡볶이 떡이 부족한 경우
            if (amount < target) {
                end = mid - 1;
            } else { // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(arr, M, 0, arr[N - 1]));
    }
}
