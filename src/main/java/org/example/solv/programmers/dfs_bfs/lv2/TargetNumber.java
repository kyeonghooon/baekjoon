package org.example.solv.programmers.dfs_bfs.lv2;

import java.util.ArrayDeque;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{numbers[0], 0});
        queue.addLast(new int[]{-numbers[0], 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            if (cur[1] + 1 < numbers.length) {
                int curIndex = cur[1] + 1;
                queue.addLast(new int[]{cur[0] + numbers[curIndex], curIndex});
                queue.addLast(new int[]{cur[0] - numbers[curIndex], curIndex});
            } else if (cur[0] == target) {
                answer++;
            }
        }
        return answer;
    }
}
