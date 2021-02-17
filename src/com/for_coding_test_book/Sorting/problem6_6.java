package com.for_coding_test_book.Sorting;

// 6_5 는 파이썬코드여서 건너뛰었음
// Note 계수정렬 (Count sort)

public class problem6_6 {

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {

        int n = 15;
        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화한다.)
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스의 값을 증가시킨다.
        }
        for (int i = 0; i <= MAX_VALUE; i++) { // 배열에 기록된 정렬 정보를 확인한다.
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " "); // 띄어쓰기를 기준으로 등장한 횟수만큼 인덱스를 출력한다.
            }
        }
    }
}
