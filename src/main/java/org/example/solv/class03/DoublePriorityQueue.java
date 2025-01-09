package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            PriorityQueue<int[]> minQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
            int index = 0;
            boolean[] valid = new boolean[k];
            for (int i = 0; i < k; i++) {
                String[] splits = br.readLine().split(" ");
                String process = splits[0];
                int n = Integer.parseInt(splits[1]);
                if (process.equals("I")) {
                    maxQueue.add(new int[]{n, index});
                    minQueue.add(new int[]{n, index});
                    index++;
                } else if (n == 1) {
                    while (!maxQueue.isEmpty()) {
                        int[] cur = maxQueue.poll();
                        if (!valid[cur[1]]) {
                            valid[cur[1]] = true;
                            break;
                        }
                    }
                } else {
                    while (!minQueue.isEmpty()) {
                        int[] cur = minQueue.poll();
                        if (!valid[cur[1]]) {
                            valid[cur[1]] = true;
                            break;
                        }
                    }
                }
            }
            int[] max = getValidElement(maxQueue, valid);
            int[] min = getValidElement(minQueue, valid);
            if (max == null || min == null) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(max[0]).append(" ").append(min[0]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int[] getValidElement(PriorityQueue<int[]> queue, boolean[] valid) {
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            if (!valid[element[1]]) {
                return element;
            }
        }
        return null;
    }
}
