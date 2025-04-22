package org.example.solv.marathon.course046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class InfiniteArraySwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> A = new HashMap<>();
        Map<Integer, Integer> B = new HashMap<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            A.put(a, A.getOrDefault(a, 0) + 1);
            B.put(b, B.getOrDefault(b, 0) + 1);
        }
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        Iterator<Integer> iter = A.keySet().iterator();
        int count = 0;
        while (iter.hasNext()) {
            int a = iter.next();
            int aCount = A.get(a);
            if (B.containsKey(a)) {
                int bCount = B.get(a);
                while (aCount > 0 && bCount > 0) {
                    sbA.append(a).append(" ");
                    sbB.append(a).append(" ");
                    aCount--;
                    bCount--;
                    count++;
                }
                if (aCount == 0) {
                    iter.remove();
                } else {
                    A.put(a, aCount);
                }
                if (bCount == 0) {
                    B.remove(a);
                } else {
                    B.put(a, bCount);
                }
            }
        }
        for (int a : A.keySet()) {
            int aCount = A.get(a);
            while (aCount-- > 0) {
                sbA.append(a).append(" ");
            }
        }
        for (int b : B.keySet()) {
            int bCount = B.get(b);
            while (bCount-- > 0) {
                sbB.append(b).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(sbA);
        System.out.println(sbB);
    }
}
