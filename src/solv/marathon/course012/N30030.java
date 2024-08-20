package solv.marathon.course012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N30030 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println(a / 11 * 10);
	}

}
