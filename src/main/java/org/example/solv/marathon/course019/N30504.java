package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N30504 {

    private static class Node implements Comparable<Node> {
        int num;
        int idx;

        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        PriorityQueue<Node> A = new PriorityQueue<Node>();
        PriorityQueue<Integer> B = new PriorityQueue<Integer>();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            A.offer(new Node(Integer.parseInt(st.nextToken()), i));
            B.offer(Integer.parseInt(st2.nextToken()));
        }
        while (!A.isEmpty()) {
            Node a = A.poll();
            int b = B.poll();
            if (b >= a.num) {
                result[a.idx] = b;
            } else {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
