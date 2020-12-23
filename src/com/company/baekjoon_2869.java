package com.company;

import java.util.*;

public class baekjoon_2869 {
    public static void main(String[] args) {
        // 정상에 도달한 경우에는 미끄러지지 않는다는 조건을 주의해야한다.
        // V(높이), A(상승), B(하강)
        // V / A - B 로 풀게 되면 정상에 도달했을때도 한번 또 하강하게돼서 정답에 +1이 된다.
        // 또 상승횟수보다 하강하는 경우의 수는 항상 하나 적으므로
        // 이를 정상에 딱맞게 도달했을 때 하강하는 경우의 수를 하나 빼고 시작한다.
        // 즉 V-B / A - B로 정답을 도출할 수 있다.
        // 만약에 V - B / A - B 의 값에 나머지가 발생하면
        // 한번더 상승해버리면 된다.

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int day = (V - B) / (A - B);
        if((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.print(day);

    }
}