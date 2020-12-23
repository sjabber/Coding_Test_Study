package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1152 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] word = str.split(" ");
        int result = word.length;

        for(int i=0; i<word.length; i++) {
            if(word[i].isEmpty()) {
                result --;
            }
        }

        System.out.print(result);
        br.close();
    }
}