package org.example.solv.marathon.course021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4848 {

    static String[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new String[16];
        dpSet();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            int index1 = -1;
            int index2 = -1;
            for (int j = 0; j < dp.length; j++) {
                if (dp[j].equals(str1)) {
                    index1 = j;
                }
                if (dp[j].equals(str2)) {
                    index2 = j;
                }
                if (index1 != -1 && index2 != -1) {
                    break;
                }
            }
            sb.append(dp[index1 + index2]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dpSet() {
        dp[0] = "{}";
        for (int j = 1; j < dp.length; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int k = 0; k < j; k++){
                sb.append(dp[k]);
                if (k != j - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            dp[j] = sb.toString();
        }
    }

}
