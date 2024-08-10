package solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N13073 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			int S1 = (n * (n + 1)) / 2;
			int S2 = n * n;
			int S3 = n * (n + 1);
			bw.write(S1 + " " + S2 + " " + S3);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
