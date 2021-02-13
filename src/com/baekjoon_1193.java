package com;

import java.io.*;

public class baekjoon_1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int sum = 0, i = 0;
        String result = "";

        while(true) {
            if(X <= sum) {
                break;
            } else {
                i++; // 몇번째 그룹인지 저장한다.
                sum += i; // 계차수열 1, 3, 6, 10, 15, ...
            }
        }

        int num = sum - X; //그룹내 순번
        int Group = i+1; // 분자 + 분모의 값

        // 분자 + 분모의 값이 짝수일 경우
        if (Group % 2 == 0) {
            if(num != 0) {
                result = num+1 + "/" + (i-num);
            } else {
                result = 1 + "/" + i;
            }
        // 분자 + 분모의 값이 홀수일 경우 (짝수의 반대로 하면 됨)
        } else {
            if(num != 0) {
                result = i-num + "/" + (num+1);
            } else {
                result = i + "/" + 1;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
