package solv.marathon.course011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N3003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		bw.write(1 - Integer.parseInt(token.nextToken()) + " ");
		bw.write(1 - Integer.parseInt(token.nextToken()) + " ");
		bw.write(2 - Integer.parseInt(token.nextToken()) + " ");
		bw.write(2 - Integer.parseInt(token.nextToken()) + " ");
		bw.write(2 - Integer.parseInt(token.nextToken()) + " ");
		bw.write(8 - Integer.parseInt(token.nextToken()) + " ");
		bw.flush();
		bw.close();
	}

}
