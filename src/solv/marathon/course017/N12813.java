package solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N12813 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder and = new StringBuilder();
		StringBuilder or = new StringBuilder();
		StringBuilder xor = new StringBuilder();
		StringBuilder notA = new StringBuilder();
		StringBuilder notB = new StringBuilder();
		String A = br.readLine();
		String B = br.readLine();
		br.close();
		for (int i = 0; i < A.length(); i++) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			if (a == '1' & b == '1') {
				and.append("1");
			} else {
				and.append("0");
			}
			if (a == '1' || b == '1') {
				or.append("1");
			} else {
				or.append("0");
			}
			if (a != b) {
				xor.append("1");
			} else {
				xor.append("0");
			}
			if (a == '0') {
				notA.append("1");
			} else {
				notA.append("0");
			}
			if (b == '0') {
				notB.append("1");
			} else {
				notB.append("0");
			}
		}
		System.out.println(and);
		System.out.println(or);
		System.out.println(xor);
		System.out.println(notA);
		System.out.println(notB);
	}

}
