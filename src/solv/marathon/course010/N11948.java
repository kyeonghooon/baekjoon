package solv.marathon.course010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N11948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] scienceList = new int[4];
		for (int i = 0; i < 4; i++) {
			scienceList[i] = Integer.parseInt(br.readLine());
		}
		int[] socialList = new int[2];
		for (int i = 0; i < 2; i++) {
			socialList[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(scienceList);
		int sum = scienceList[1] + scienceList[2] + scienceList[3] + Math.max(socialList[0], socialList[1]);
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
