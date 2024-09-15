package solv.marathon.course015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4806 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowCount = 0;
		String str = null;
		while ((str = br.readLine()) != null) {
			rowCount++;
		}
		System.out.println(rowCount);
	}
}
