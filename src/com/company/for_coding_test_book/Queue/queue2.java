package com.company.for_coding_test_book.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue2 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // 큐를 사용하기 위해선 LinkedList<>를 같이 사용해야한다. (자바에서는)

        q.add(5);
        q.add(2);
        q.add(3);
        q.add(7);
        q.poll();
        q.offer(1);
        q.add(4);
        q.remove();

        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }



    }
}
