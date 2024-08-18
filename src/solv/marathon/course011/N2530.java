package solv.marathon.course011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2530 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(token.nextToken());
		int minute = Integer.parseInt(token.nextToken());
		int second = Integer.parseInt(token.nextToken());
		int time = Integer.parseInt(br.readLine());
		int resultSec = hour * 3600 + minute * 60 + second + time;
		int resultH = resultSec / 3600;
		resultH = resultH > 23 ? resultH % 24 : resultH;
		int resultM = (resultSec % 3600) / 60;
		int resultS = (resultSec % 3600) % 60;
		bw.write(resultH + " " + resultM + " " + resultS);
		bw.flush();
		bw.close();
	}

}
