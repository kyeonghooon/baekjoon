package org.example.solv.programmers.hash.lv2;

import java.util.*;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> hashSet = new HashSet<>();
        for (String phone : phone_book) {
            hashSet.add(phone);
        }
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (hashSet.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
