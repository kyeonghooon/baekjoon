package org.example.solv.programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SelectMandarin {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        return answer;
    }
}
