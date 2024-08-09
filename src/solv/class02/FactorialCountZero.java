package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FactorialCountZero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (i % 125 == 0) {
				result += 3;
			} else if (i % 25 == 0) {
				result += 2;
			} else if (i % 5 == 0) {
				result += 1;
			}
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
