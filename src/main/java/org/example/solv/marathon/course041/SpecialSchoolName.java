package org.example.solv.marathon.course041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialSchoolName {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        switch (str) {
            case "NLSC":
                answer = "North London Collegiate School";
                break;
            case "BHA":
                answer = "Branksome Hall Asia";
                break;
            case "KIS":
                answer = "Korea International School";
                break;
            case "SJA":
                answer = "St.Johnsbury Academy";
                break;
        }
        System.out.println(answer);
    }
}
