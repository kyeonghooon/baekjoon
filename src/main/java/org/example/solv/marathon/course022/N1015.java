package org.example.solv.marathon.course022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1015 {

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            int result = o.value - value;
            if (result == 0) result = o.index - index;
            return result;
        }

        @Override
        public String toString() {
            return "\n" + index + " " + value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, value);
        }
        Arrays.sort(nodes);
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[nodes[i].index] = N - 1 - i;
        }
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.print(sb);
    }

}
