package com.company.for_coding_test_book;

// greedy 거스름돈 문제
// 시간복잡도 O(N)
public class problem3_1 {
    public static void main(String[] args) {
        int n = 1260;
        int cnt = 0; //필요한 동전의 개수
        int[] coinType = {500, 100, 50, 10};

        for(int i = 0; i < coinType.length; i++) {
            int coin = coinType[i];
            cnt += n / coin;
            // 각 동전당 필요한 개수를 원금을 나눔으로서 구할 수 있다.
            n %= coin;
        }

        System.out.println(cnt);
    }
}
