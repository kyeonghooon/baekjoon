package solv.marathon.course017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class N27434 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		if (N == 0) {
			System.out.println(1);
			return;
		}
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= N; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		System.out.println(result.toString());
	}
}
