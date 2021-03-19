package com.company.for_coding_test_book.swmaestro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static ArrayList<ArrayList<Integer>> skill = new ArrayList<ArrayList<Integer>>();
    public static boolean[] check = new boolean[128];
    public static ArrayList<Character> result = new ArrayList<Character>();

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll(" ", ""); // 공백제거
        //sc.nextLine(); // 버퍼제거

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int tmp = ch - '0';
            tmp = tmp + 48;
            check[tmp] = true; // 해당 스킬이 단독스킬인지 검증하기 위함
        }

        // 스킬의 개수를 입력받는다.
        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 제거

        // 아스키코드표 만큼의 스킬배열을 생성한다.
        for (int i = 0; i < 128; i++) {
            skill.add(new ArrayList<Integer>());
        }

        // 연계 스킬들을 입력받는다.
        for (int i = 0; i < N; i++) {
            String str2 = sc.nextLine();
            str2 = str2.replaceAll(" ", "");
            int tmp1 = str2.charAt(0) - '0';
            int tmp2 = str2.charAt(1) - '0';
            tmp1 = tmp1 + 48;
            tmp2 = tmp2 + 48;
            check[tmp2] = false; // 해당 스킬은 단독스킬이 아님.
            skill.get(tmp1).add(tmp2);
        }

        int num = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                num = i;
                break;
            }
        }

        dfs(num);

        // 시간재기
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("수행시간(ms) : " + secDiffTime);
    }

    public static void dfs(int num) {
        char ch = (char) num;
        result.add(ch);

        if (!skill.get(num).isEmpty()) {
            for (int i = 0; i < skill.get(num).size(); i++) {

                int tmp = skill.get(num).get(i);
                dfs(tmp);
            }
            result.remove(result.size() - 1);
        } else {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            result.remove(size - 1);
        }
    }
}
