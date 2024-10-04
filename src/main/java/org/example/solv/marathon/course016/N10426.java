package org.example.solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class N10426 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		LocalDate startDate = LocalDate.parse(token.nextToken(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate anniversaryDate = startDate.plusDays(Integer.parseInt(token.nextToken()) - 1);
		System.out.println(anniversaryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
}
