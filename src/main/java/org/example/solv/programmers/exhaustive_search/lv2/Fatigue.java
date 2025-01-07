package org.example.solv.programmers.exhaustive_search.lv2;

import java.util.*;

public class Fatigue {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int totalCount = dungeons.length;
        int remainIndex = dungeons.length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < totalCount; i++) {
            int[] visited = new int[totalCount + 1];
            if (k < dungeons[i][0]) continue;
            visited[i]++;
            visited[remainIndex] = k - dungeons[i][1];
            queue.addLast(visited);
        }
        while (!queue.isEmpty()) {
            int T = queue.size();
            answer++;
            while (T-- > 0) {
                int[] cur = queue.pollFirst();
                int remain = cur[remainIndex];
                for (int i = 0; i < totalCount; i++) {
                    if (cur[i] > 0 || remain < dungeons[i][0]) continue;
                    int[] newArr = Arrays.copyOf(cur, cur.length);
                    newArr[i]++;
                    newArr[remainIndex] = remain - dungeons[i][1];
                    queue.addLast(newArr);
                }
            }

        }
        return answer;
    }
}
