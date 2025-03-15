package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimilarPlate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int trash = Integer.parseInt(input[1]);
            Map<String, Integer> map = new HashMap<>();
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int[] frequency = new int[26];
                int uppercaseCount = 0;
                String str = input[i];
                for (char ch : str.toCharArray()) {
                    if (ch >= 'A' && ch <= 'Z') {
                        uppercaseCount++;
                        frequency[ch - 'A']++;
                    } else {
                        frequency[ch - 'a']++;
                    }
                }
                String key = Arrays.toString(frequency) + "_" + uppercaseCount;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int answer = 0;
            for (int count : map.values()) {
                answer += count * (count - 1) / 2;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
