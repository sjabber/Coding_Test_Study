package com;

class SuperClass { //부모클래스
    int aa = 11;
    int bb = 12;
    public SuperClass() { // 부모 생성자
        int aa2 = 111;
        int bb2 = 222;
        System.out.println("부모 생성자 호출");
    }

    public void print() {
        System.out.println("부모란다.");
    }
}

class SubClass extends SuperClass{ // 부모클래스를 참조하는 자식클래스
    int aaa = 1;
    int bbb = 2;
    public SubClass() { // 자식 생성자
        System.out.println("자식 생성자 호출");
    }

    public void print() {
        System.out.println("자식이란다.");
    }
}
public class important_concept {
    public static void main(String[] args) {
        SuperClass sc2 = new SubClass(); // Note 생성자의 경우 부모거는 자동으로 호출된다.
        System.out.println();

        System.out.println(sc2.aa);
        System.out.println(sc2.bb);
        System.out.println();
//        System.out.println(sc2.aaa);
//        System.out.println(sc2.bbb);
        sc2.print();
        System.out.println(); // Note 메서드는 오버라이딩된 메서드가 호출된다.
    }
}
