package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AdmissionStrategy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] splits = br.readLine().split(" ");
        int K = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);
        int N = Integer.parseInt(splits[2]);
        Map<String, Integer> map = new HashMap<>();
        while (K-- > 0) {
            splits = br.readLine().split(" ");
            map.put(splits[0], Integer.parseInt(splits[1]));
        }
        int count = M - N;
        int sum = 0;
        while (N-- > 0) {
            sum += map.remove(br.readLine());
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int min = sum;
        int max = sum;
        while (count-- > 0) {
            min += list.get(count);
            max += list.get(list.size() - 1 - count);
        }
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }

}
