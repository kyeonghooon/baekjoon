package solv.marathon.course016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11023 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splits = br.readLine().split(" ");
		int sum = 0;
		for (int i = 0; i < splits.length; i++) {
			sum += Integer.parseInt(splits[i]);
		}
		System.out.println(sum);
	}
}
