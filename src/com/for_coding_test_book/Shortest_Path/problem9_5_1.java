package com.for_coding_test_book.Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class city implements Comparable<city>{

    private int index;
    private int distance;

    // 커스텀 생성자
    public city(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(city o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class problem9_5_1 {

    public static int N, M, C;

    public static int[] dist; // 최단거리 정보를 담는다.

    public static ArrayList<ArrayList<city>> graph = new ArrayList<>();

    public static void dijkstra(int start) {


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dist = new int[N+1];

        for (int i = 0; i <= N; i++) {
            // 그래프를 초기화한다.
            graph.add(new ArrayList<city>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int N;
        }


    }
}
