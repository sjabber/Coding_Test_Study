package com.greedy;


import java.io.*;

// 그리디(탐욕법) -> 당장 눈앞에 보이는 최적의 상황만 고르는 알고리즘
// 단순한 형태이면서 난이도가 낮다.
// 그리디는 항상 최적의 결과를 도출하는건 아니지만 근사치를 빠르게 구할 수 있다는 장점이 있다.
// 특정상황에서는 최적해를 보장하기도 한다.
public class baekjoon_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] arr = new int[N];

        for(int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int coin = 0;
        for (int i = N-1; i >= 0; i --) {
            if (arr[i] <= K) {
                coin += (K / arr[i]);
                K = K % arr[i];
            }
        }

        bw.write(String.valueOf(coin));
        bw.flush();
        bw.close();
    }
}
