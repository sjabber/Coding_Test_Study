package com.for_coding_test_book.problem;

import java.util.Scanner;


//프로그래머스 괄호변환 (카카오 문제)
//https://programmers.co.kr/learn/courses/30/lessons/60058?language=java

public class p_16 {

    public static int balanced(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                num += 1;
            } else {
                num -= 1;
            }

            if (num == 0) {
                return i;
            }
        }

        return -1;
    }

    public static boolean checkProper(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                num += 1;
            } else {
                if (num == 0) {
                    return false;
                }
                num -= 1;
            }
        }

        return true;
    }

    public static String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balanced(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // 올바른 괄호 문자열 일 경우 v에 대한 함수를 수행한 결과를 붙여 반환한다.
        if (checkProper(u)) {
            answer = u + solution(v);
        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1, u.length() - 1); // 첫번째와 마지막 문자제거
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    temp += ")";
                } else {
                    temp += "(";
                }
            }

            answer += temp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = solution(str);
        System.out.println(str);
    }
}