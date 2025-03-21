package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RightTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            arr[i][0] = x;
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
            int y = Integer.parseInt(input[1]);
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
            arr[i][1] = y;
        }
        long answer = 0L;
        for (int i = 0; i < N; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int countX = mapX.get(x) - 1;
            int countY = mapY.get(y) - 1;
            answer += (long) countX * countY;
        }
        System.out.println(answer);
    }
}
