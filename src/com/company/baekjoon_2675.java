package com.company;

import java.io.*;

public class baekjoon_2675 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(bf.readLine());

        for(int i = 0; i < num; i++) {

            String[] str = bf.readLine().split(" ");
            int N = Integer.parseInt(str[0]);

            //입력이
            // 2
            //3 ABC
            //5 /HTP 일 경우

            for(byte val : str[1].getBytes()) {
                // byte val에 str[1]의 바이트 길이만큼 반복해서 대입한다.
                // str[1]의 바이트길이 -> ABC 의 길이만큼을 의미한다.
                for(int l = 0; l < N; l++) {
                    sb.append((char)val);
                }
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
