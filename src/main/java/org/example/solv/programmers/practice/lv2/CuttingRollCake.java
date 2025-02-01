package org.example.solv.programmers.practice.lv2;

import java.util.HashMap;

public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> me = new HashMap<>();
        HashMap<Integer, Integer> you = new HashMap<>();
        for (int j : topping) {
            you.put(j, you.getOrDefault(j, 0) + 1);
        }
        for (int n : topping) {
            me.put(n, you.getOrDefault(n, 0) + 1);
            you.put(n, you.getOrDefault(n, 0) - 1);
            if (you.get(n) == 0) you.remove(n);
            if (me.size() == you.size()) answer++;
        }
        return answer;
    }
}
