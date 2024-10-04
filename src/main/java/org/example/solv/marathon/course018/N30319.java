package org.example.solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class N30319 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LocalDate limitDate = LocalDate.parse("2023-10-21");
		LocalDate submittedDate = LocalDate.parse(br.readLine());
		if (submittedDate.isAfter(limitDate.minusDays(35))) {
			System.out.println("TOO LATE");
		} else {
			System.out.println("GOOD");
		}
	}
}
