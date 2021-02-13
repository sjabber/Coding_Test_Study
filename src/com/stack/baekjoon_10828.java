package com.stack;

//자료구조 stack 에 관한 문제
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class baekjoon_10828 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case "push" :
                    int input = Integer.parseInt(cmd[1]);
                    stack.push(input);
                    break;

                case "pop" :
                    if (stack.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;

                case "size" :
                    bw.write(stack.size() + "\n");
                    break;

                case "empty" :
                    if (stack.isEmpty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;

                case "top" :
                    if (stack.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }

        } // 반복문 마감

        br.close();
        bw.flush();
        bw.close();
    }
}
