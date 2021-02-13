package com;

import java.util.Scanner;

public class baekjoon_2908 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int A = sc.nextInt();
            int B = sc.nextInt();
            sc.close();

            A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
            B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());

            System.out.print(A > B ? A : B);
        }
}


//또는 이렇게 풀어도됨
//public class Main {
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
//        String b = sc.next();
//        String c = "";
//        String d = "";
//
//        for(int i = a.length() - 1; i >= 0; i--) {
//            c += a.charAt(i);
//        }
//
//        for(int i = b.length() -1; i >=0; i--) {
//            d += b.charAt(i);
//        }
//
//        int A = Integer.parseInt(c);
//        int B = Integer.parseInt(d);
//
//        if (A > B) {
//            System.out.print(A);
//        } else {
//            System.out.print(B);
//        }
//    }
//}