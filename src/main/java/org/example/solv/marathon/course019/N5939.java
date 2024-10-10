package org.example.solv.marathon.course019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N5939 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		List<MyTime> times = new ArrayList<MyTime>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			times.add(new MyTime(h, m, s));
		}
		Collections.sort(times);
		for (MyTime time : times) {
			sb.append(time.toString()).append("\n");
		}
		System.out.println(sb);
	}

	static class MyTime implements Comparable<MyTime> {
		int hour, minute, second;
		public MyTime(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		@Override
		public int compareTo(MyTime o) {
			if (this.hour > o.hour) return 1;
			else if (this.hour < o.hour) return -1;
			else if (this.minute > o.minute) return 1;
			else if (this.minute < o.minute) return -1;
			else if (this.second > o.second) return 1;
			else if (this.second < o.second) return -1;
			return 0;
		}

		@Override
		public String toString() {
			return hour + " " + minute + " " + second;
		}
	}
}
