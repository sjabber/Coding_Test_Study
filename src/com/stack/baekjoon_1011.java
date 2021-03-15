package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x;
            System.out.println(Engine(dist));
        }

        br.close();
    }

    // 시간초과로 인해 다시 규칙찾음..
    public static int Engine(int dist) {

        int count = (int) Math.sqrt(dist);

        if (count == Math.sqrt(dist)) {
            return (2 * count - 1);
        } else if (dist <= count * count + count) {
            return (2 * count);
        } else {
            return (2 * count) + 1;
        }
    }
}

//    public static int Engine(int dist) {
//
//        int index = 1; // 더해지는 값
//        int result = 0; // 비교할 합계
//        int count = 1; // 정답을 담는 변수
//
//        int test = 0; // 디버깅할때 편하려고 만든 변수
//
//        Loop:
//        while(true) {
//            if (dist == 1) {
//                return count;
//            }
//
//            for (int i = 0; i < 2; i++) {
//
//                result += index;
//                count++;
//
//                if (i == 0) {
//                    test = result + index;
//                    if (result < dist && dist <= test) {
//                        //count++;
//                        break Loop;
//                    }
//                } else {
//                    test = result + (index + 1);
//                    if (result < dist && dist <= test) {
//                        //count++;
//                        break Loop;
//                    }
//                }
//            }
//            index++;
//        }
//
//        return count;
//    }
//}
