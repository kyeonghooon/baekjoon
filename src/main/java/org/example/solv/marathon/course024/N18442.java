package org.example.solv.marathon.course024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N18442 {

    static int V, P;
    static long L;
    static long[] villages;
    static long[][] distance;
    static long minSum = Long.MAX_VALUE;
    static List<Integer> bestCombination = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        villages = new long[V];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            villages[i] = Long.parseLong(st.nextToken());
        }
        distance = new long[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distance[i][j] = circularDistance(villages[i], villages[j]);
            }
        }
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(0, 0, currentCombination);

        System.out.println(minSum);
        Collections.sort(bestCombination);
        for (int i = 0; i < bestCombination.size(); i++) {
            System.out.print(villages[bestCombination.get(i)]);
            if (i != bestCombination.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    static void generateCombinations(int start, int count, List<Integer> current) {
        if (count == P) {
            long currentSum = calculateSum(current);
            if (currentSum < minSum) {
                minSum = currentSum;
                bestCombination = new ArrayList<>(current);
            } else if (currentSum == minSum) {
                // Optional: Choose lex smallest combination
                List<Long> currentPositions = new ArrayList<>();
                List<Long> bestPositions = new ArrayList<>();
                for (int idx : current) {
                    currentPositions.add(villages[idx]);
                }
                for (int idx : bestCombination) {
                    bestPositions.add(villages[idx]);
                }
                boolean isBetter = false;
                for (int i = 0; i < P; i++) {
                    if (currentPositions.get(i) < bestPositions.get(i)) {
                        isBetter = true;
                        break;
                    } else if (currentPositions.get(i) > bestPositions.get(i)) {
                        break;
                    }
                }
                if (isBetter) {
                    bestCombination = new ArrayList<>(current);
                }
            }
            return;
        }

        for (int i = start; i <= V - (P - count); i++) {
            current.add(i);
            generateCombinations(i + 1, count + 1, current);
            current.remove(current.size() - 1);
        }
    }

    static long calculateSum(List<Integer> combination) {
        long sum = 0;
        for (int i = 0; i < V; i++) {
            long minDist = Long.MAX_VALUE;
            for (int postOffice : combination) {
                if (distance[i][postOffice] < minDist) {
                    minDist = distance[i][postOffice];
                }
                if (minDist == 0) break;
            }
            sum += minDist;
            if (sum >= minSum) break;
        }
        return sum;

    }

    static long circularDistance(long x, long y) {
        long direct = Math.abs(x - y);
        return Math.min(direct, L - direct);
    }
}
