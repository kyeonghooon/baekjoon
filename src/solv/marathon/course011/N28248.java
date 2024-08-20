package solv.marathon.course011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N28248 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = A > B ? 500 : 0;
		int result = A * 50 - B * 10 + C;
		System.out.println(result);
	}

}
