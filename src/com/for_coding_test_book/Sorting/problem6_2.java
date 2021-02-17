package com.for_coding_test_book.Sorting;

//Note 스와프
// 스와프란 특정한 리스트가 주어졌을 경우 두 변수의 위치를 변경하는 작업을 의미
public class problem6_2 {
    public static void main(String[] args) {

        int[] arr = {3, 5};

        // 스와프
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        System.out.println(arr[0] + " " + arr[1]);

    }
}
