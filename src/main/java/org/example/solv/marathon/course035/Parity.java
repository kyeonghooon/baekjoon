package org.example.solv.marathon.course035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parity {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while (!(str = br.readLine()).equals("#")) {
            boolean odd = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case '1':
                        odd = !odd;
                        sb.append(c);
                        break;
                    case '0' :
                        sb.append(c);
                        break;
                    case 'e' :
                        sb.append(odd ? 1 : 0).append("\n");
                        break;
                    case 'o' :
                        sb.append(odd ? 0 : 1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}
