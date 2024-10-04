package org.example.solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MovieDirectorShome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		br.close();
		int check = 0;
		int num = 0;
		while(check < count) {
			num++;
			if (String.valueOf(num).contains("666")) {
				check++;
			}
		}
		bw.write(num + "");
		bw.flush();
		bw.close();
	}
	
}
