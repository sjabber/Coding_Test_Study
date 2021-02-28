package com.company.for_coding_test_book.swmaestro;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static int p, n, h;

    public static ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        p = sc.nextInt(); // pc 개수
        n = sc.nextInt(); // 예약 손님 수
        h = sc.nextInt(); // pc방 최대 이용시간

        int count = 0; // 총 손님이 이용한 시간

        // ArrayList 초기화
        for (int i = 0; i <= p; i++) {
            x.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            x.get(a).add(b);
        }

        for (int i = 1; i <= p; i++) {
            count = 0;
            for (int j = 0; j < x.get(i).size(); j++) {
                if (x.get(i).get(j) > h) {
                    continue;
                } else {
                    int result = x.get(i).get(j);
                    if (count + result <= h) {
                        count = Math.max(result, count + result);
                    }
                }

            }
            System.out.println(i + " " + count * 1000);
        }
    }
}