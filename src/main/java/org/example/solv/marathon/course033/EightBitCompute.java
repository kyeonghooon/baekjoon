package org.example.solv.marathon.course033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EightBitCompute {

    private static final long MAX_VALUE = 134217728L;
    private static final long MIN_VALUE = -134217728L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Pattern pattern = Pattern.compile("^(-?\\d+)([+\\-*/])(-?\\d+)$");
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            System.out.println("invalid");
            return;
        }
        long a = Long.parseLong(matcher.group(1), 8);
        String operator = matcher.group(2);
        long b = Long.parseLong(matcher.group(3), 8);
        long result = 0;
        switch (operator) {
            case "+" :
                result = a + b;
                break;
            case "-" :
                result = a - b;
                break;
            case "*" :
                result = a * b;
                break;
            case "/" :
                if (b == 0) {
                    System.out.println("invalid");
                    return;
                }
                result = a / b;
                if ((a % b != 0) && ((a < 0) != (b < 0))) {
                    result--;
                }
                break;
            default:
                System.out.println("invalid");
                return;
        }

        if (result < 0) {
            System.out.println("-" + Long.toOctalString(-result));
        } else {
            System.out.println(Long.toOctalString(result));
        }
    }

}
