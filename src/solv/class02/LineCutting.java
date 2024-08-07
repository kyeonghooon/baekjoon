package solv.class02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LineCutting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(token.nextToken());
		int after = Integer.parseInt(token.nextToken());
		int[] lineList = new int[before];
		long sum = 0;
		for (int i = 0; i < lineList.length; i++) {
			lineList[i] = Integer.parseInt(br.readLine());
			sum += lineList[i];
		}
		br.close();
		long max = (int)(sum / after);
		long left = 1;
		long right = max;
		long length = 0;
		while (left <= right) {
			long mid = (right + left) / 2;
			int count = 0;
			for (int i = 0; i < lineList.length; i++) {
				count += lineList[i] / mid;
			}
			if (count >= after) {
				length = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		bw.write(length + "");
		bw.flush();
		bw.close();
	}

}
