package solv.marathon.course012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N4635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String countStr = null;
		while (!(countStr = br.readLine()).equals("-1")) {
			int count = Integer.parseInt(countStr);
			int[] mphList = new int[count];
			int[] mileList = new int[count];
			for (int i = 0; i < count; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				mphList[i] = Integer.parseInt(token.nextToken());
				mileList[i] = Integer.parseInt(token.nextToken());
			}
			int sum = mphList[0] * mileList[0];
			for (int i = 1; i < mileList.length; i++) {
				sum += mphList[i] * (mileList[i] - mileList[i - 1]);
			}
			bw.write(sum + " miles\n");
		}
		bw.flush();
		bw.close();
	}

}
