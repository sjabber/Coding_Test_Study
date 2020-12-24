package com.company.for_coding_test_book;

import java.util.Scanner;

public class problem3_4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // n이 k로 나누어지기 위해 만들어지는 수 -> target
            int target = (n / k) * k;
            result += (n - target); // 1을 몇번 빼야하는지 바로 구해진다.
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복분 탈출
            if (n < k) break;

            result += 1;
            n /= k; // 이제 나누어질 조건이 만족됐으므로 k로 나누고 result 값 1 증가
        }

        // 마지막으로 남은 수에 대해 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }
}
