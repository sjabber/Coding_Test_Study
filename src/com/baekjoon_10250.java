package com;

import java.util.Scanner;

public class baekjoon_10250 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int Num = sc.nextInt();

        for (int i = 0; i < Num; i++) {

           int H = sc.nextInt();
           int W = sc.nextInt();
           int N = sc.nextInt();

           if(N%H == 0) {
               System.out.println(H*100 + N/H);

           } else {
               System.out.println((N%H)*100 + (N/H)+1);
           }
        }
    }
}
