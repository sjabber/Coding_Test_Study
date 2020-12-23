package com.company.sorting;

// 여전히 선택정렬~
//BufferedWriter 대신 StringBuilder 를 사용해본다.

import java.io.*;

class baekjoon_2750_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Num = Integer.parseInt(br.readLine());
        int[] numArray = new int[Num];

        for (int i = 0; i < Num; i++) {
            numArray[i] = Integer.parseInt(br.readLine());
        }

        // select sort
        for(int i = 0; i < Num-1; i ++) {
            for(int j = i+1; j < Num; j++) {
                if(numArray[i] > numArray[j]) {
                    int surrogate = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = surrogate;
                }
            }
        }

        for(int value : numArray) {
            sb.append(value).append('\n');
        }

        System.out.print(sb);
    }
}
