package org.example.solv.programmers.practice.lv2;

import java.util.*;

public class ContiguousSubarraySumCount {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    int index = (j + k) % elements.length;
                    sum += elements[index];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
