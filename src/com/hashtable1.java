package com;

// Linked list 로 구현된 해시테이블에 대한 실습.

import java.util.LinkedList;

class HashTable {
    LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for(char c : key.toCharArray()) {
            // String key 변수의 글자 하나하나가 배열로 변환되어 char c에 들어간다.
            hashCode += c;
        }
        // 아스키코드값이 hashCode 에 더해진다.
        // 각 글자들의 값이 다 더해지면 해시코드 완성

        return hashCode;
}

    int convertToIndex(int hashCode) {

        // 위에서 더해져서 구해진 해시코드들을 데이터의 길이로 나눈 나머지가
        // 인덱스의 값이다. (저장될 자리)

        return hashCode % data.length;
        // 알고리즘에서 나누기 방법으로 인덱스(키) 값을 반환
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if(list == null) return null;

        for(Node node : list) {
            if(node.key.equals(key)) {

                return node;
            }
        }

        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];

        // 1. data[해당 인덱스]가 존재하지 않으면 list 에 null 값이 들어가겠지?
        // 2. 그러면 list 를 초기화 해주고 list 를 인덱스값에 해당하는 data[]에 넣어준다.

        if(list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if(node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);

        return node == null ? "Not found" : node.getValue();
    }

    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

public class hashtable1 {
    public static void main(String[] args) {
        HashTable ht = new HashTable(3);
        ht.put("sung", "She is pretty");
        ht.put("jin", "She is model");
        ht.put("hee", "She is angel");
        ht.put("min", "She is cute");

        System.out.println(ht.get("sung"));
        System.out.println(ht.get("jin"));
        System.out.println(ht.get("hee"));
        System.out.println(ht.get("min"));
        System.out.println(ht.get("jae"));
    }
}

