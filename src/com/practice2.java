package com;

import java.util.HashMap;
import java.util.HashSet;

public class practice2 {

    static boolean[] bool = new boolean[46];
    static int[] number = new int[6];

    public static void main(String[] args) {
//
//        int[] array_int = new int[300];
//
//        for (int i = 0;  i < array_int.length; i++) {
//            array_int[i] = (int) (Math.random() * 100);
//            System.out.println(array_int[i]);
//            hashSet.add(array_int[i]);
//        }
//        System.out.println();
//        System.out.println("서로 다른 숫자의 개수 : " + hashSet.size());

//        int[] lotto_num = new int[45];
//        for (int i = 0; i < 45; i++) {
//            lotto_num[i] = i + 1;
//        }
//
//        for (int i = 0; i < 1000; i++) {
//            int num = (int) (Math.random() * 44) + 1;
//            int temp = lotto_num[0];
//            lotto_num[0] = lotto_num[num];
//            lotto_num[num] = temp;
//        }
//
//        for (int i = 1; i < 7; i++) {
//            System.out.println("i : " + i + " : " + lotto_num[i-1]);
//        }

        lotto();
        System.out.println("-----------------");
        SelectSort(number);
        System.out.print("-----------------");
    }

    static void lotto() {
        bool[0] = true;
        int count = 0;
        while (count < 6) {
            int num = (int) (Math.random() * 46);
            if (!bool[num]) {
                bool[num] = true;
                number[count] = num;
                //System.out.print(num + " ");
                count++;
            }
        }
    }

    static void SelectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j; // 가장 작은 수의 인덱스를 저장
                }
            }

            // 스와프
            int temp = arr[i]; // 원래 값 임시저장
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
