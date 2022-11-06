package com.for_coding_test_book.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student2 implements Comparable<Student2>{

    private String name;
    private int score;

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // 정렬 기준은 점수가 낮은 순서 (점수에 대한 오름차순)
    @Override
    public int compareTo(Student2 other) {
//        return this.score - other.score; // 오름차순 정렬
        return other.score - this.score; // 내림차순 정렬

//        if(this.score < other.score) { // other가 더 크면 내림차순됨
//            return -1; // 이경우 반대로 뒤집음 -> 오름차순
//        }
//        return 1;
    }
}

public class problem6_11_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        ArrayList<Student2> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");
            Student2 obj = new Student2(str[0], Integer.parseInt(str[1]));
            list.add(obj);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getName() + " ");
        }

        sc.close();
    }
}
