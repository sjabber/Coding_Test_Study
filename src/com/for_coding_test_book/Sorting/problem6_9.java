package com.for_coding_test_book.Sorting;

// 키나 값을 기준으로 데이터를 정렬할 경우 예시

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Fruit implements Comparable<Fruit> {

    private String name;
    private int score;

    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준은 `점수가 낮은 순서` (오름차순)
    @Override
    public int compareTo(Fruit other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}



public class problem6_9 {

    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + ", " + fruits.get(i).getScore() + ") ");
        }
    }
}
