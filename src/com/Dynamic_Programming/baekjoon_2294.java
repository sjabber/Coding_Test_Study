package com.Dynamic_Programming;

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class baekjoon_2294 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");

        int n = Integer.parseInt(num[0]);
        int k = Integer.parseInt(num[1]);
        int[] coin = new int[n];
        int[] arr = new int[k+1];

        Arrays.fill(arr, 100001);
        arr[0] = 0;
        // 배열을 전부 100001로 채우고 0번째는 0으로 만든다.
        // 0은 그 어떤 동전에도 해당하지 않음, 0원짜리 동전이 있어?

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            for(int j = coin[i]; j < k+1; j++) {
                arr[j] = Math.min(arr[j], arr[j-coin[i]]+1);
                // 해당 동전 숫자의 배수에 걸리게되면 +1 씩 증가된다.
                // 못만드는 숫자 -> 그 어떤 배수에도 조합되지 않는 수는 100001로 그대로 현상유지되고
                // 기존 방법이랑 조합한 방법이랑 비교해서 더 적은 수로 만들어지는 수가 결과로 나온다.
                // 동전이 2인 경우 2부터 시작하게되고 3은 100002랑 100001이랑 비교하게되므로 100001로 그대로 현상유지
            }
        }

        System.out.print(arr[k] == 100001 ? -1 : arr[k]);
    }
}