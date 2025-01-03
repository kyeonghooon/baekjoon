package org.example.solv.programmers.stack_queue.lv2;

import java.util.*;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int day = 0;
        int[] dayOfRelease = new int[100];
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + day * speeds[i] < 100) {
                day++;
            }
            dayOfRelease[day]++;
        }
        return Arrays.stream(dayOfRelease).filter(i -> i != 0).toArray();
    }
}
