package com.for_coding_test_book.DFS_BFS;
//Note 인접 리스트리스트
// 연결리스트를 사용한다.

// 자바의 LinkedList vs ArrayList(동적배열)
// ArrayList는 내부적으로 데이터를 배열에서 관리하며 데이터에 인덱스가 존재하여 데이터 검색에 유리
// LinkedList는 인덱스가 없지만 데이터의 추가와 삭제에 유리
// 하지만 -> 인덱스가 없어 데이터를 순차적으로 조회하여 조회성능은 좋지못하다.

import java.util.ArrayList;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.println("(" + this.index +  "," + this.distance + ")");
    }
}

public class Adjacency_List {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보를 저장한다.
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1).add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2).add(new Node(0,5));

        // 그래프 출력
        for(int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }

    }
}
