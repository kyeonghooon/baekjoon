package solv.marathon.course015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11104 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append(Integer.parseInt(br.readLine(), 2)).append("\n");
		}
		System.out.println(sb);
	}
}
