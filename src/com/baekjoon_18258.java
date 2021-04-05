package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(N-- > 0) { // N의 값이 0보다 클 때까지 감소시킨다.
            st = new StringTokenizer(br.readLine(), " ");	// 문자열 분리

            switch(st.nextToken()) {

                case "push":
                    // offer는 큐의 맨 뒤에 요소를 추가한다.
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    Integer i = q.poll();
                    if(i == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(i).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    Integer tmp = q.peek();
                    if(tmp == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(tmp).append('\n');
                    }
                    break;

                case "back":
                    // peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer tmp2 = q.peekLast();
                    if(tmp2 == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(tmp2).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
