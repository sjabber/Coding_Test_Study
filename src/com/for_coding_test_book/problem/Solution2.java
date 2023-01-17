package com.for_coding_test_book.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {
    public int[] solution(int[][] data) {
        int len = data.length;
        int[] answer = new int[len];

        int index = data[0][2]; // 기준점
        answer[0] = data[0][0];

        ArrayList<printer> list = new ArrayList<>();// 대기열

        for (int i = 1; i < len; i++) {
            if (index - data[i][1] > 0) {
                printer p = new printer(data[i][0], data[i][2]);
                list.add(p);
                index += data[i][2];
            } else {
                answer[i] = data[i][0];
                index = data[i][1] + data[i][2];

                Collections.sort(list, new Comparator<printer>() {
                    @Override
                    public int compare(printer o1, printer o2) {
                        if (o1.getPage() < o2.getPage()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                });

            }
        }

        for (int i = 0; i < len; i++) {
            if (answer[i] == 0) {
                answer[i] = list.get(0).getNumber();
                list.remove(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] data = {{1,2,10}, {2,5,8}, {3,6,9}, {4,20,6}, {5, 25, 5}};
        int[] result = solution.solution(data);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class printer {
    private int number;
    private int page;

    public printer(int number, int page) {
        this.number = number;
        this.page = page;
    }

    public int getNumber() {
        return number;
    }

    public int getPage() {
        return page;
    }
}
