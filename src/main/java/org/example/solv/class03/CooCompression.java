package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CooCompression {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        int[] sortedValues = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = sortedValues[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sortedValues);
        HashMap<Integer, Integer> valueToCompressed = new HashMap<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!valueToCompressed.containsKey(sortedValues[i])) {
                valueToCompressed.put(sortedValues[i], count++);
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(valueToCompressed.get(values[i])).append(" ");
        }
        System.out.println(sb);
    }

}
