package org.example.solv.marathon.course036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BeerFestival {

    static class Beer implements Comparable<Beer> {
        int preference;
        int alcohol;

        public Beer(int preference, int alcohol) {
            this.preference = preference;
            this.alcohol = alcohol;
        }

        @Override
        public int compareTo(Beer o) {
            return Integer.compare(this.alcohol, o.alcohol);
        }
    }

    static int N, K;
    static long M;
    static Beer[] beers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        K = Integer.parseInt(splits[2]);
        beers = new Beer[K];
        int minAlcohol = Integer.MAX_VALUE;
        int maxAlcohol = 0;
        for (int i = 0; i < K; i++) {
            splits = br.readLine().split(" ");
            int preference = Integer.parseInt(splits[0]);
            int alcohol = Integer.parseInt(splits[1]);
            beers[i] = new Beer(preference, alcohol);
            minAlcohol = Math.min(minAlcohol, alcohol);
            maxAlcohol = Math.max(maxAlcohol, alcohol);
        }
        Arrays.sort(beers);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        int answer = -1;

        for (Beer beer : beers) {
            if (minHeap.size() < N) {
                // 아직 N개 미만이면 그냥 추가
                minHeap.offer(beer.preference);
                sum += beer.preference;
            } else {
                if (minHeap.peek() < beer.preference) {
                    sum -= minHeap.poll();
                    minHeap.offer(beer.preference);
                    sum += beer.preference;
                }
            }
            if (minHeap.size() == N && sum >= M) {
                answer = beer.alcohol;
                break;
            }
        }

        System.out.println(answer);
    }


}
