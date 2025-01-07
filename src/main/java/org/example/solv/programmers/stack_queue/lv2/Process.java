package org.example.solv.programmers.stack_queue.lv2;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            int n = priorities[i];
            priorityQueue.add(n);
            queue.add(new int[]{n, i});
        }
        boolean flag = true;
        while (flag) {
            if (priorityQueue.peek() == queue.peek()[0]) flag = true;
        }
        return answer;
    }
}
