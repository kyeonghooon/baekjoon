package org.example.solv.marathon.course037;

import java.io.IOException;
import java.util.ArrayList;

public class TimetableScheduler {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        ArrayList<ArrayList<Integer>> subList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int k = readInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (k-- > 0) {
                list.add(readInt());
            }
            subList.add(list);
        }
        int M = readInt();
        for (int i = 0; i < M; i++) {
            int p = readInt();
            boolean[] arr = new boolean[51];
            for (int j = 0; j < p; j++) {
                arr[readInt()] = true;
            }
            int count = 0;
            for (int j = 0; j < N; j++) {
                boolean fail = false;
                for (int num : subList.get(j)) {
                    if (!arr[num]) {
                        fail = true;
                        break;
                    }
                }
                if (!fail) count++;
            }
            System.out.println(count);
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return rs;
    }

}
