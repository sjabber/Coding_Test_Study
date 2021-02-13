package com;

import java.util.Scanner;

public class baekjoon_1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();

        int[] array = new int[26];
        int max = 0;
        char result = '?';

        for(int i=0; i < str.length(); i++) {
            array[str.charAt(i) - 'A'] ++;

            if(max < array[str.charAt(i) - 'A']) {
                // 배열 str.charAt(i) - 'A' == A(65) - A(65)라서 0이 된다.

                max = array[str.charAt(i) - 'A'];
                // 최대값 비교를 위해 필요함. 해당 번호의 배열값이 최대인경우 max 에 삽입한다.

                result = str.charAt(i);
                // 가장 많이 나온 문자를 출력한다. str.charAt(i)

            } else if(max == array[str.charAt(i) - 'A']) {
                result = '?';
            }
        }

        System.out.print(result);
        sc.close();
    }
}
