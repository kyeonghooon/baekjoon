package org.example.solv.marathon.course037;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DirtRoadRepair {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int L = readInt();
        final int START = 0;
        final int END = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(N, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N; i++) {
            pq.offer(new int[]{readInt(), readInt()});
        }
        int answer = 0;
        int cur = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[START] > cur) {
                cur = curr[START] + L;
                answer++;
            }
            int need = (curr[END] - cur + L - 1) / L;
            answer += need;
            cur += need * L;
        }
        System.out.println(answer);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }
}
