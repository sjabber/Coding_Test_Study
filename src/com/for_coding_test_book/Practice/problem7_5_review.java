package com.for_coding_test_book.Practice;

import java.io.*;
import java.util.*;

public class problem7_5_review {

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        String[] str1 = br.readLine().split(" ");

        int M = sc.nextInt();
        String[] str2 = br.readLine().split(" ");

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }

        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            if (binarySearch(arr1, 0, N-1, arr2[i])) System.out.print("yes ");
            else System.out.print("no ");
        }

        br.close();
    }
}
