package org.example.solv.programmers.kakao_intern.lv2;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2);
        String[] splits = s.split("\\},\\{");
        answer = new int[splits.length];
        Arrays.sort(splits, Comparator.comparingInt(String::length));
        boolean[] check = new boolean[100001];
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            String[] arr = str.split(",");
            for (String number : arr) {
                int num = Integer.parseInt(number);
                if (!check[num]) {
                    answer[i] = num;
                    check[num] = true;
                }
            }
        }
        return answer;
    }
}
