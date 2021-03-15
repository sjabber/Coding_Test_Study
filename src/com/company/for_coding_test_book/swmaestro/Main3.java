package com.company.for_coding_test_book.swmaestro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static char[] skill;
    public static String[] result;
    public static ArrayList<ArrayList<Character>> skill_list = new ArrayList<ArrayList<Character>>();

    public static void solution(char input) {

        for (int i = 0; i < skill.length; i++) {
            char sk = skill[i];
            int a = sk - '0';
            System.out.print(sk + " ");
            if (skill_list.contains(a)) {
                for (int j = 0; j < skill_list.get(a).size(); i++) {
                    sk = skill_list.get(a).get(j);
                    int b = skill_list.get(a).get(j) - '0';
                    System.out.print(sk + " ");
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // ex) h g f w r
        sc.nextLine(); // 버퍼 제거

        int num = sc.nextInt();
        sc.nextLine(); // 버퍼 제거

        str = str.replaceAll(" ", ""); // 공백을 제거한다. hgfwr
        skill = str.toCharArray();
        // 0 -> h
        // 1 -> g
        // 2 -> f
        // 3 -> w
        // 4 -> r

        // 스킬의 갯수만큼 정답을 담을 배열의 크기를 초기화한다.
        result = new String[skill.length];

        // 스킬 연계목록 초기화
        for (int i = 0; i < 128; i++) { // ASCII 코드표 개수만큼 초기화
            skill_list.add(new ArrayList<Character>());
        }

        // 연계 스킬들을 입력받는다.
        for (int i = 0; i < num; i++) {
            String str2 = sc.nextLine();
            str2 = str2.replaceAll(" ", "");

            int a = str2.charAt(0) - '0'; // 단독 스킬
            skill_list.get(a).add(str2.charAt(1));

            // ex) h g -> [h][0] : g
            // ex) h f -> [h][1] : f
        }






    }
}
