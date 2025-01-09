package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class DoublePriorityQueueTreeMap {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                String[] splits = br.readLine().split(" ");
                String cmd = splits[0];
                int n = Integer.parseInt(splits[1]);
                if (cmd.equals("I")) {
                    treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) continue;
                    int num = n == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    if (treeMap.get(num) == 1) treeMap.remove(num);
                    else treeMap.put(num, treeMap.get(num) - 1);
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }

}
