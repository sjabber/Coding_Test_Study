package com.for_coding_test_book.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        //Note 큐는 스택과 달리 LinkedList<>를 생성자로 사용한다.

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        q.offer(5); // q.add(5)를 해도 된다.
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll(); // q.remove()를 해도 된다.
        q.offer(1);
        q.offer(4);
        q.poll();
        // 선입선출이므로 3 7 1 4 가 출력된다.
        // 먼저 들어온 원소부터 추출
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }

        q.clear();
        System.out.println(q.poll());
        System.out.println(q.add(3)); // 삽입 성공시 true 반환
        System.out.println(q.offer(4)); // 삽입 성공시 true 반환
        // poll 은 비어있으면 null 을 반환하고
        // remove 는 런타임 에러발생.

    }
}
