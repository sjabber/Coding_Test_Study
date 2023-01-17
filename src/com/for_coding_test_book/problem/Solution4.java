package com.for_coding_test_book.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    int demeritTarget(String[] id_list, String target) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(target))
                return i;
        }

        return -1;
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] demerit = new int[id_list.length];

        Set<String> check = new HashSet<>();
        for (String repo : report) {
            if (!check.contains(repo)) {
                check.add(repo);
                String[] str = repo.split(" ");
                String target = str[1];
                int index = demeritTarget(id_list, target);
                demerit[index]++;
            }
        }

        for (String repo : report) {
            String[] str = repo.split(" ");
            String user = str[0];
            String target = str[1];

            int index = demeritTarget(id_list, target);
            if (demerit[index] >= k) {
                index = demeritTarget(id_list, user);
                answer[index]++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = solution4.solution(id_list, report, k);
        for (int answer : result) {
            System.out.print(answer + " ");
        }
    }
}
