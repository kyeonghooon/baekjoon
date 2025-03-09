package org.example.solv.programmers.heap.lv2;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int size = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            pq.offer(scoville[i]);
        }
        while(!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            } else {
                int min = pq.poll();
                int min2 = pq.poll();
                int mix = min + min2 * 2;
                answer++;
                pq.offer(mix);
            }
        }
        return answer;
    }
}
