package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1316 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int result = 0; // 답을 센다.
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i < num; i++) {
            if(check()) {
                result++;
            }
        }
        System.out.print(result);
    }

    public static boolean check() throws IOException{
        boolean[] checker = new boolean[26];
        String str = br.readLine();
        int prev = 0;

        for(int i=0; i < str.length(); i++) {
            int now = str.charAt(i); // 아스키 코드값으로 알아서 변환되어 삽입된다.

            if(prev != now) { //앞과 뒤가 같지 않으면서
                if(!checker[now - 'a']) { //뒤에거가 전에 나오지 않았던 거라면
                    checker[now - 'a'] = true; //뒤에거는 나왔다고 표시를 한다.
                    prev = now;
                } else { //만약 그렇지 않다면 -> 뒤에거가 나왔던 전적이 있으면 (true)면
                    return false; // 그룹단어가 아니다.
                }
            } else { // 앞과 뒤가 같으면
                continue; // 다음 반복문으로 넘어간다. (i++)
            }
        }
        return true;
    }
}