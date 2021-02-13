package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2292 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0; // 정답
        int i = 0, sum = 0; // 조건을 검사할 공간
        int num = Integer.parseInt(br.readLine()); // 입력받을 공간

        while(true) {
            if(num <= sum + 1) {
                result = i + 1;
                break;
            } else {
                i ++;
                sum += (6 * i);
            }
        }

        System.out.print(result);
    }
}
