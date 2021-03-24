package com;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        br.close();

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간을 기준으로 정렬하되
                // 종료시간이 같은 경우 시작시간을 기준으로 정렬한다.
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });


        int endtime = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            // 시작시간이 직전 회의 종료시간과 같거나 늦은 시간이면
            // 카운트를 1 증가
            if (time[i][0] >= endtime) {
                endtime = time[i][1];
                count ++;
            }
        }
        System.out.print(count);
    }
}
