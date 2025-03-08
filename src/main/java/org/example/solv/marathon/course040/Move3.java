package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Move3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        long finalX = Integer.parseInt(splits[0]);
        long finalY = Integer.parseInt(splits[1]);
        Deque<long[]> queue = new ArrayDeque<>();
        queue.addLast(new long[]{0, 0, -1});
        boolean find = false;
        if (finalX == 0 && finalY == 0) find = true;
        while (!queue.isEmpty() && !find) {
            long[] cur = queue.removeFirst();
            long x = cur[0];
            long y = cur[1];
            long k = cur[2] + 1;
            long nx = x + (long) Math.pow(3, k);
            long ny = y + (long) Math.pow(3, k);
            if (nx == finalX && y == finalY) {
                find = true;
            }
            if (x == finalX && ny == finalY) {
                find = true;
            }
            if (nx <= finalX) queue.addLast(new long[]{nx, y, k});
            if (ny <= finalY) queue.addLast(new long[]{x, ny, k});
        }
        System.out.println(find ? 1 : 0);
    }

}
