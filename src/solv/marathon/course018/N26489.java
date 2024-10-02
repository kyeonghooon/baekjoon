package solv.marathon.course018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N26489 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		int count = 0;
		while ((str = br.readLine()) != null) {
			count++;
		}
		System.out.println(count);
	}
}
