package com.for_coding_test_book.Binary_Search;

import java.util.Arrays;
import java.util.Scanner;

class RiceCake {
    private int start;
    private int end;

    RiceCake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}

public class problem7_8 {
    public static RiceCake BinarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end)/2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) { // 목표 높이와 중간 값이 같을 경우
                RiceCake rc = new RiceCake(mid, end);
                return rc;
            } else { // 목표 높이가 중간값보다 작을 경우 바로 시작지점 반환
                RiceCake rc = new RiceCake(start, end);
                return rc;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 보유한 떡의 개수
        int M = sc.nextInt(); // 목표 길이

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int H = arr[N-1] - 1;

        while(H >= 0) {
            RiceCake rc = BinarySearch(arr, H, 0, N-1);
            if (rc == null) {
                break;
            }

            int start = rc.getStart();
            int end = rc.getEnd();
            int sum = 0;

            for (int i = start; i < end + 1; i++) {
                int temp = arr[i] - H;
                sum = sum + temp;
            }

            if (sum >= M) {
                break;
            } else {
                H = H - 1;
            }
        }

        System.out.print(H);
    }
}
