package solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N15680 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n1 = Integer.parseInt(br.readLine());
		br.close();
		if (n1 == 0) {
			bw.write("YONSEI");
		} else {
			bw.write("Leading the Way to the Future");
		}
		bw.flush();
		bw.close();
	}

}
