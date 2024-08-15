package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FindPrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(token.nextToken());
		int max = Integer.parseInt(token.nextToken());
		min = min == 1 ? 2 : min;
		for (int i = min; i <= max; i++) {
			boolean check = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					check = true;
					break;
				}
			}
			if (check == false) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
}
