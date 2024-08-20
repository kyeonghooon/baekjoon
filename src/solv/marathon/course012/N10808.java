package solv.marathon.course012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10808 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		for (int i = 'a'; i <= 'z'; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == i) {
					count++;
				}
			}
			bw.write(count + " ");
		}
		bw.flush();
		bw.close();
	}

}
