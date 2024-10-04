package org.example.solv.marathon.course013;

import java.time.LocalDateTime;

public class N16170 {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime result = localDateTime.minusHours(9);
		StringBuilder sb = new StringBuilder();
		sb.append(result.getYear() + "\n");
		sb.append(result.getMonthValue() + "\n");
		sb.append(result.getDayOfMonth());
		System.out.println(sb);
	}

}
