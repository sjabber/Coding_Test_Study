package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Note 너무 오래걸렸음. 그때 그때 고민하면서 해결하려기 보다는
// 먼저 점화식을 잘 세우고 반복 사용되는 값은 변수로 만들어 놓도록 하자. (잊어버리면 다시찾아야하고 헷갈린다.)
public class baekjoon_1932 {

    public static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr.add(0);

        for (int  i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = sc.nextInt();
                arr.add(tmp);
            }
        }

        // 0번 인덱스 값은 1번 인덱스 값과 동일하게 둔다.
        arr.set(0, arr.get(1));

        int tmp = 1;
        for (int i = 1; i < N; i++) { // i는 층수를 의미한다.
            tmp += i; // 맨 처음 시작하는 배열의 인덱스 값
            for (int j = 0; j <= i; j++) {
                int now = tmp + j; // 원래 값
                int right = now - i; // 오른쪽 상단 값
                int left = now - i - 1; // 왼쪽 상단 값


                if (j == 0) { // 맨 왼쪽 값
                    arr.set(now, arr.get(right) + arr.get(now)); // 오른쪽 위 값  + 원래 값
                } else if (j == i) { // 맨 오른쪽 값
                    arr.set(now, arr.get(left) + arr.get(now)); // 왼쪽 위 값 + 원래 값
                } else {
                    arr.set(now, Math.max(arr.get(now) + arr.get(left), arr.get(now) + arr.get(right)));
                }
            }
        }
        // arr 배열이 가진 최대값을 뽑아낸다.
        System.out.print(Collections.max(arr));
    }
}
