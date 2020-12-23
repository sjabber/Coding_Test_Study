package com.company.stack;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_9012_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        while(N-- > 0) {
            boolean isVPS = true;
            String input = sc.nextLine();
            Stack<Character> stack = new Stack<Character>();

            char tmp;
            for(int i = 0; i < input.length(); i++) {
                tmp = input.charAt(i);
                if(tmp == '(') {
                    stack.add(tmp);
                } else if(tmp == ')') {
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty())
                isVPS = false;

            if(isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
