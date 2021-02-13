package com.greedy;


import java.io.*;

//Note 나동빈 그리디알고리즘 강의내용
public class Practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine()); //내야할 금액

        br.close();

        int coin = 0; // 동전의 개수를 센다.
        int[] coins = new int[4];
        coins[0] = 500;
        coins[1] = 100;
        coins[2] = 50;
        coins[3] = 10;

        for (int i = 0; i < coins.length; i++) {
            coin += (num / coins[i]);
            num = num % coins[i];
        }

        bw.write(String.valueOf(coin));
        bw.flush();
        bw.close();
    }
}
