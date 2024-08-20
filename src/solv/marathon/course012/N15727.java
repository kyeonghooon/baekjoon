package solv.marathon.course012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int t = (int) Math.ceil((double)L / 5);
		System.out.println(t);
	}

}
