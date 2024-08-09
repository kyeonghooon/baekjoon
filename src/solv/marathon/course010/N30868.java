package solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N30868 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			int quotient = n / 5;
			int remainder = n % 5;
			for (int j = 0; j < quotient; j++) {
				bw.write("++++ ");
			}
			for (int j = 0; j < remainder; j++) {
				bw.write("|");
			}
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
