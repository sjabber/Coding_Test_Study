package com.for_coding_test_book.Binary_Search;

import java.io.*;
import java.util.Arrays;

public class problem7_5 {

    // 이진 탐색 소스코드 구현
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (end + start) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str1;
        str1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }

        // 이진 탐색을 수행하기 위해 사전에 정렬을 수행한다.
        Arrays.sort(arr);

        // M(손님이 요청한 부품의 개수)
        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        String[] str2;
        str2 = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            target[j] = Integer.parseInt(str2[j]);
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인한다.
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인한다.
            int result = binarySearch(arr, target[i], 0, n-1);
            if (result == -1) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }

    }
}
