package com.company.Dynamic_Programming;

// 동전 거슬러주는 문제

import java.util.Scanner;

public class DP {

    static int[] change;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        change = new int[100];

        System.out.println("거스름돈을 입력해주세요:");
        int i = sc.nextInt();

        calc_change();

        System.out.println("지불해야하는 거스름돈 개수 :" + change[i]);

    }

    static void calc_change(){
        change[0]=0;

        for(int i=1; i<100; i++){
            change[i] = min_change(i)+1;
        }

    }

    static int min_change(int i){
        int min = change[i-1];
        if(i>=3){
            if(min>change[i-3]) min = change[i-3];
        }
        if(i>=4){
            if(min>change[i-4]) min = change[i-4];
        }
        return min;
    }

    // 문제는 너가 최소한의 동전만으로 거슬러줘야한다는 것
    // 이렇게 생각하면 쉽다.
    // 너가 10원 30원 40원짜리 동전을 가지고 있고 50원을 거슬러줘야한다면
    // 10원짜리는 5개 30원짜리라면 1개 40원짜리라면 1개 일것이다.
    // 저 중에서 30원 1개 40원 1개로 최소한의 동전개수는 1이 나온다.
    // 여기다 그냥 +1 해버리면 최소한의 필요동전개수 나온다.
}
