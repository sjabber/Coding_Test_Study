package com.company;

import java.io.*;
//board : 10 x 10   start : 2,2   갈수있는곳 : 0   벽 : 1   먹이 : 2   first : 오른쪽   second : 왼쪽

public class codeup_1099 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            String[] array = br.readLine().split(" ");
            for(int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(array[j]);
            }
        }
        br.close();

        int start = 1;

        Loop1 :
        for (int i = 1; i < arr.length; i++) {
            for(int j = start; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 9;
                } else if (arr[i][j] == 1) {
                    start = j - 1;
                    continue Loop1;
                } else if (arr[i][j] == 2) {
                    arr[i][j] = 9;
                    break Loop1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}