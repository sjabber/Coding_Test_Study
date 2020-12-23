package com.company.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);
        int coin[] = new int[n];
        int dp[] = new int[k+1];

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // Note 이부분이 핵심이다.
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j < k+1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.print(dp[k] == 100001? -1 : dp[k]);
    }
}
