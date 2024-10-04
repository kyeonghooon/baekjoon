package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SortingByAge {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		StringBuilder[] list = new StringBuilder[201];
		for (int i = 0; i < count; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(token.nextToken());
			String name = token.nextToken();
			if (list[age] == null) {
				list[age] = new StringBuilder();
			}
			list[age].append(age + " " + name + "\n");
		}
		br.close();
		for (int i = 0; i < 201; i++) {
			if (list[i] == null) {
				continue;
			}
			bw.write(list[i].toString());
		}
		bw.flush();
		bw.close();
	}

}
