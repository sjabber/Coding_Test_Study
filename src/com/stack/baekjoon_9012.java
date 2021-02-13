package com.stack;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_9012 {
    public static String isVPS(String word) {
        word = word.trim(); // 문자열 공백제거 (문자 사이사이 공백은 지워주지 않음)
        //Note 가운데 공백은 replace로 지워주어야 한다.

        char[] arr = word.toCharArray();
        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]=='(')
                cnt = cnt + 1;
            else
                cnt = cnt - 1;
            if(cnt < 0) {
                return "NO";
            }
        }

        if(cnt == 0)
            return "YES";
        else
            return "NO";
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n -- > 0) {
            System.out.println(isVPS(sc.nextLine()));
        }
    }
}
