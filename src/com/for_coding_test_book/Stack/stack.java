package com.for_coding_test_book.Stack;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();
        //최상단부터 출력
        while (!s.empty()) {
            // 5 2 3 1
            // s.empty() 가 true 일 때 까지 반복
            System.out.println(s.peek());
            // 출력 : 1 3 2 5
            s.pop();
        }
    }
}
