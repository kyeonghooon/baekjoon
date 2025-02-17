package org.example.solv.marathon.course037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ClassroomAllocation {

    static class Event implements Comparable<Event> {
        int time, type;

        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            return this.time == o.time ? Integer.compare(type, o.type) : Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Event> pq = new PriorityQueue<Event>();
        String[] splits = null;
        while (N-- > 0) {
            splits = br.readLine().split(" ");
            int s = Integer.parseInt(splits[0]);
            int t = Integer.parseInt(splits[1]);
            pq.add(new Event(s, 1));
            pq.add(new Event(t, -1));
        }
        int count = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            count += pq.poll().type;
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

}
