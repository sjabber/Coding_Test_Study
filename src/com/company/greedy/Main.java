package com.company.greedy;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        // int[N][0] -> 시작시간
        // int[N][1] -> 종료시간

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int endtime = 0;

        for (int i = 0; i < N; i++) {
            if (endtime <= time[i][0]) {
                endtime = time[i][1];
                count++;
                // 가장 빠른 종료시간보다 크거나 같은 시작시간이 있는 경우
                // count를 하나씩 추가
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}