package solv.marathon.course013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N28691 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		switch (str) {
		case "M":
			System.out.println("MatKor");
			break;
		case "W":
			System.out.println("WiCys");
			break;
		case "C":
			System.out.println("CyKor");
			break;
		case "A":
			System.out.println("AlKor");
			break;
		case "$":
			System.out.println("$clear");
			break;
		}
	}

}
