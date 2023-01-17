package com.for_coding_test_book.problem;

public class Solution3 {

    public long solution(int[] histogram) {
        long answer = 0;
        int len = histogram.length;
        for (int i = 0; i < len; i++) {
            int left = histogram[i]; // 왼쪽 기둥의 높이
            for (int j = i+2; j < len; j++) {
                int right = histogram[j];
                int height = Math.min(left, right);
                int bottom = j-i-1;
                // 영역의 넓이
                long area = height * bottom;

                answer = Math.max(answer, area);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] histogram = {6, 5, 7, 3, 4, 2};
        long result = solution3.solution(histogram);
        System.out.println(result);
    }
}
