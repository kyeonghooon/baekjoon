package org.example.solv.programmers.hash.lv2;

import java.util.HashMap;

public class Outfit {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int result = 1;
        for (int value : map.values()) {
            result *= (value + 1);
        }
        answer = result - 1;
        return answer;
    }
}
