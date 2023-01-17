package com.for_coding_test_book.Practice;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String Name, int Score) {
        this.name = Name;
        this.score = Score;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setScore(int Score) {
        this.score = Score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score < o.score)
            return -1;
        return 1;
    }
}

public class problem6_11_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String Name = sc.next();
            int Score = sc.nextInt();

            Student student = new Student(Name, Score);
            list.add(student);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.print(student.getName() + " ");
        }
    }
}
