package solv.marathon.course011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N29699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "WelcomeToSMUPC";
		int N = Integer.parseInt(br.readLine());
		int mod = N % 14;
		mod = mod == 0 ? 14 : mod;
		bw.write(str.charAt(mod - 1) + "");
		bw.flush();
		bw.close();
	}

}
