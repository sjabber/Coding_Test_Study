package com.company.stack;

import java.io.*;
import java.util.Stack;

public class baekjoon_10773 {

    public static void main(String[] args) throws IOException {

        //Integer -> wrapper 클래스 (기본타입 int 를 객체로 표현하기 위해 사용함)

        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i < N; i ++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        br.close();
        N = stack.size();

        for (int i = 0; i < N; i++) {
            result += stack.pop();
        }

        //Note 이런 방법도 있었다...
//        while(!stack.isEmpty()) {
//            result += stack.pop();
//        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
