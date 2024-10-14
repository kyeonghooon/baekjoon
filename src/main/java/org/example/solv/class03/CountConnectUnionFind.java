package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountConnectUnionFind {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];

        // 각 노드의 부모를 자기 자신으로 초기화하고, 랭크를 0으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 간선 정보 입력 및 유니온 처리
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            union(a, b);
        }

        // 연결 요소 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) { // 루트 노드일 경우 count 증가
                count++;
            }
        }

        System.out.println(count);
    }

    // Find 함수: 경로 압축을 적용하여 부모를 찾아주는 함수
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // Union 함수: 두 집합을 랭크에 따라 병합
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // 랭크를 비교하여 더 작은 트리를 더 큰 트리 밑에 병합
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA; // rootB를 rootA 밑에 둠
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB; // rootA를 rootB 밑에 둠
            } else {
                // 랭크가 같으면 아무 쪽이나 병합하고, 병합된 쪽의 랭크를 1 증가시킴
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

}
