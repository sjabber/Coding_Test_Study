package com.for_coding_test_book.Sorting;

//important 퀵정렬!!
// 호어분열 방식을 적용함 (배열 맨 처음값을 피벗, 기준삼아서 정렬함)
public class problem6_4 {

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료한다.
        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;
            // 위의 반복과정이 끝마쳐지면 이제 데이터 값을 서로 교환한다.
            // 엇갈렸다면 작은 데이터와 피벗을 교체한다. (위에서 마땅히 찾은 값이 없는경우..)
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                // 이후 반복문 종료됨.
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체한다.
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행한다.
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
