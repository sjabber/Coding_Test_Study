package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2565_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전선의 개수
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[501];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        int max = 0;

        for (int i = 1; i <= 500; i++) {
            if (arr[i] == 0) continue;

            // 각 전선별 최대값을 기록하기위한 변수 선언.
            int result = 1;

            // 현재 전선의 연결지점
            int tmp = arr[i];
            int tmp2 = 0; // 자기보다 윗줄의 수때문에 넣음.

            for (int j = 1; j <= 500; j++) {
                // 값이 없는 경우 건너뛴다.
                if (arr[j] == 0) continue;
                if (i == j) continue;

                // 자기보다 아래 줄일 경우
                if (i < j) {
                    if (arr[j] > tmp) {
                        // 자기보다 값이 크다면 추가하고 갱신.
                        result++;
                        tmp = arr[j];
                    }

                // 자기보다 위의 줄일 경우
                } else if (i > j) {
                    if (arr[j] < tmp && arr[j] > tmp2) {
                        // 자기보다 값이 작으면서 이전 윗줄보다 값이 큰경우 추가하고 갱신.
                        result++;
                        tmp2 = arr[j];
                    }
                }
            }

            max = Math.max(max, result);
        }

        br.close();
        System.out.println(num - max);
    }
}
