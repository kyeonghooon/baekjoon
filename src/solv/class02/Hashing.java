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
		long[] list = new long[length];
		String str = br.readLine();
		for (int i = 0; i < list.length; i++) {
			list[i] = str.charAt(i) - 'a' + 1;
		}
		long sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += (long)Math.pow(31, i) * list[i];
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
