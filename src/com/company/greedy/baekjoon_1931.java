package com.company.greedy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_1931 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();


		/*
		  time[][0] 은 시작시점을 의미
		  time[][1] 은 종료시점을 의미
		*/
        int[][] time = new int[N][2];


        for (int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();    // 시작시간
            time[i][1] = in.nextInt();    // 종료시간
        }


        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                //Integer.compare 메서드에서 매개변수 1과 2중
                // 2가 더 크면 음수(-1)를 반환하여 오름차순
                // 같으면 0을 반환하여 오름차순
                // 작으면 양수(1)를 반환하여 내림차순이다.
                // 즉, return 값이 Note 0이나 -1이면 오름차순, 1이면 내림차순으로 정렬

                // 종료시간이 같을 경우 (시작시간이 빠른순으로 정렬해야한다.)
                if (o1[1] == o2[1]) {
//                    System.out.println(o1[0] - o2[0]);
//                    System.out.println("a");
                    return o1[0] - o2[0];
                    // o2 나중에 거가 더 커서 음수를 반환하면 오름차순이 된다.
                    // 오름차순이면 순서가 안바뀌는거랑 같다..
                    // 먼저거가 더 커서 양수면 내림차순이 된다.
                    // 즉 순서가 바뀐다.

                    // Note 더 이해하기 쉽게 정리
                    // Note 종료시간이 같은놈들 중에서는 시작시간이 더 빠른놈이 먼저 존재해야함
                    // o1[0] o2[0] 중에서 o2[0]가 더 크다?
                    // o1[0] -> o2[0] 오름차순
                    // o1[1] o2[0] 중에서 o1[0]가 더 크다?
                    // o2[0] -> o1[0] 내림차순

                    // 시작시간이 두번째 매개변수(o2[0])가 더
                }

                // 두번째 매개변수가 더크면 오름차순
                // 아니면 내림차순정렬렬
               System.out.println(o1[1] - o2[1]);
                System.out.println("b");
                return o1[1] - o2[1];
            }

        });

//        Arrays.sort(time);

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < N; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if (prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
// https://hooongs.tistory.com/63 참고
