package solv.marathon.course013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1712 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		long bep = 0l;
		if (C <= B) {
			bep = -1;
		} else {
			bep = A / (C - B) + 1;
		}
		System.out.println(bep);
	}

}
