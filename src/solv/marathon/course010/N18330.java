package solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N18330 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int use = Integer.parseInt(br.readLine());
		int left = Integer.parseInt(br.readLine());
		br.close();
		int half = left + 60;
		if (use > half) {
			bw.write((half * 1500) + ((use - half) * 3000) + "");
		} else {
			bw.write(use * 1500 + "");
		}
		bw.flush();
		bw.close();
	}

}
