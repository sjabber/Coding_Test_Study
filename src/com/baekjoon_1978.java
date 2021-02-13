package com;

import java.util.Scanner;

public class baekjoon_1978 {
    // 소수찾기 문제
    // 소수 = 1과 자기 자신만으로 나누어지는 수
    // 즉 나누어서 0이 되는 수가 두번만 나와야 한다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B, check, result  = 0;

        for(int i = 0; i < A; i++) {
            check = 0;
            B = sc.nextInt();
            for(int k = 1; k <= B; k++) {
                if(B % k == 0) {
                    check ++;
                }
            }
            if(check == 2) {
                result ++;
            }
        }

        System.out.print(result);
    }

}
