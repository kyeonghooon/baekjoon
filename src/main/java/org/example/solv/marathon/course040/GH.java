package org.example.solv.marathon.course040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GH {

    static boolean[] used = new boolean[10];
    static int[] arr = new int[10];
    static Set<Integer> set = new HashSet<>();
    static int[] success;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 10; i++) {
            String[] split = br.readLine().split(" ");
            arr[i] = calculate(split[0], split[1], split[2]);
        }
        success = setting();
        combination(1, 0, new int[3]);
        int n = Integer.parseInt(br.readLine());
        int score = 0;
        boolean success = false;
        while (n-- > 0) {
            String[] splits = br.readLine().split(" ");
            if (splits[0].equals("H")) {
                int n1 = Integer.parseInt(splits[1]);
                int n2 = Integer.parseInt(splits[2]);
                int n3 = Integer.parseInt(splits[3]);
                int mask = (1 << n1) | (1 << n2) | (1 << n3);
                if (set.contains(mask)) {
                    score++;
                    set.remove(mask);
                } else {
                    score--;
                }
            } else if (set.isEmpty() && !success) {
                score += 3;
                success = true;
            } else {
                score--;
            }
        }
        System.out.println(score);
    }

    static void combination(int start, int count, int[] picked) {
        if (count == 3) {
            int multiple = arr[picked[0]] * arr[picked[1]] * arr[picked[2]];
            for (int s : success) {
                if (multiple % s == 0) multiple /= s;
            }
            if (multiple == 1) set.add((1 << picked[0]) | (1 << picked[1]) | (1 << picked[2]));
        } else {
            for (int i = start; i < 10; i++) {
                if (used[i]) continue;
                used[i] = true;
                picked[count] = i;
                combination(i + 1, count + 1, picked);
                used[i] = false;
            }
        }
    }

    static int calculate(String shape, String color, String background) {
        int s = 0, c = 0, b = 0;
        switch (shape) {
            case "CIRCLE":
                s = CIRCLE;
                break;
            case "TRIANGLE":
                s = TRIANGLE;
                break;
            case "SQUARE":
                s = SQUARE;
                break;
        }
        switch (color) {
            case "YELLOW":
                c = YELLOW;
                break;
            case "RED":
                c = RED;
                break;
            case "BLUE":
                c = BLUE;
                break;
        }
        switch (background) {
            case "GRAY":
                b = GRAY;
                break;
            case "WHITE":
                b = WHITE;
                break;
            case "BLACK":
                b = BLACK;
                break;
        }
        return s * c * b;
    }

    static final int CIRCLE = 2;
    static final int TRIANGLE = 3;
    static final int SQUARE = 5;
    static final int YELLOW = 7;
    static final int RED = 11;
    static final int BLUE = 13;
    static final int GRAY = 17;
    static final int WHITE = 19;
    static final int BLACK = 23;
    static final int[] ARRAY = {CIRCLE, TRIANGLE, SQUARE, YELLOW, RED, BLUE, GRAY, WHITE, BLACK};
    static int[] setting() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((int)Math.pow(ARRAY[i], 3));
        }
        list.add(CIRCLE * TRIANGLE * SQUARE);
        list.add(YELLOW * RED * BLUE);
        list.add(GRAY * WHITE * BLACK);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
