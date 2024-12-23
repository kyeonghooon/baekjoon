package org.example.solv.programmers.lv2;

import java.util.*;

public class Cache1 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String str : cities) {
            str = str.toLowerCase();
            if (queue.contains(str)) {
                queue.remove(str);
                queue.addLast(str);
                answer++;
            } else {
                answer += 5;
                if (queue.size() < cacheSize) {
                    queue.addLast(str);
                } else {
                    if (cacheSize > 0) {
                        queue.removeFirst();
                        queue.addLast(str);
                    }
                }
            }

        }
        return answer;
    }
}
