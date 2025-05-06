package org.example.solv.marathon.course048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ACMICPC {

    static class Team implements Comparable<Team> {
        int teamNumber;
        private final int[] failCount;
        private final boolean[] success;
        int time;
        int count;

        Team(int teamNumber, int m) {
            this.teamNumber = teamNumber;
            failCount = new int[m + 1];
            success = new boolean[m + 1];
            time = 0;
            count = 0;
        }

        public void fail(int number) {
            if (success[number]) return;
            failCount[number]++;
        }

        public void success(int time, int number) {
            if (success[number]) return;
            this.time += failCount[number] * 20 + time;
            success[number] = true;
            count++;
        }

        @Override
        public String toString() {
            return teamNumber + " " + count + " " + time;
        }

        @Override
        public int compareTo(Team o) {
            int answer = Integer.compare(o.count, this.count);
            if (answer == 0) {
                answer = Integer.compare(this.time, o.time);
            }
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++) {
            teams[i] = new Team(i + 1, m);
        }
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int team = Integer.parseInt(st.nextToken()) - 1;
            int number = Integer.parseInt(st.nextToken());
            if ("AC".equals(st.nextToken())) {
                teams[team].success(time, number);
            } else {
                teams[team].fail(number);
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(teams);
        for (Team team : teams) {
            sb.append(team).append("\n");
        }
        System.out.println(sb);
    }
}
