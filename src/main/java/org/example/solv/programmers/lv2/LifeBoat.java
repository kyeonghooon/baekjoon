package org.example.solv.programmers.lv2;

import java.util.*;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] escape = new boolean[people.length];
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        if (left == right) answer++;
        return answer;
    }
}
