package com.for_coding_test_book.Practice;

import java.util.*;

public class problem7_3_review {
    public static int binarySearch(int[] arr, int start, int end, int target) {
        // 1 2 3 4
        // mid -> [1]인 2
        // 2보다 타겟인 1이 더 작아?
        // mid - 1 로 end 가 대체된다. (검색 범위 왼쪽 절반으로 줄어듦)

        // 2보다 타겟인 3이 더 커?
        // mid + 1 로 start 가 대체된다. (검색 범위 오른쪽 절반으로 줄어듦)

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        // important 이진탐색을 하기 위해서는 반드시 정렬이 선행되어야 한다.
        Arrays.sort(arr);

        int result = binarySearch(arr, 0, num-1, target);
        System.out.println(result + 1);
    }
}
