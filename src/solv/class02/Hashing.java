package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hashing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int length = Integer.parseInt(br.readLine());
		int[] list = new int[length];
		String str = br.readLine();
		for (int i = 0; i < list.length; i++) {
			list[i] = str.charAt(i) - 'a' + 1;
		}
		int MOD = 1234567891;
		long sum = 0;
		int BASE = 31;
		long power = 1;
		for (int i = 0; i < list.length; i++) {
			int value = str.charAt(i) - 'a' + 1;
			sum = (sum + (value * power) % MOD) % MOD;
			power = (power * BASE) % MOD;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
