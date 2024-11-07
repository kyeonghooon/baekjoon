package org.example.solv.class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MeetingRoomAssignment {

    static int[] startTmp;
    static int[] endTmp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        startTmp = new int[N];
        endTmp = new int[N];
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            starts[i] = Integer.parseInt(st.nextToken());
            ends[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(starts, ends, 0, N - 1);
        int count = 0;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (starts[i] >= temp) {
                count++;
                temp = ends[i];
            }
        }
        System.out.println(count);
    }

    static void mergeSort(int[] starts, int[] ends, int startPoint, int endPoint) {
        if (startPoint < endPoint) {
            int sepPoint = (startPoint + endPoint) / 2;
            mergeSort(starts, ends, startPoint, sepPoint);
            mergeSort(starts, ends, sepPoint + 1, endPoint);
            merge(starts, ends, startPoint, sepPoint, endPoint);
        }
    }

    static void merge(int[] starts, int[] ends, int startPointer, int sepPointer, int endPointer) {
        int leftPointer = startPointer;
        int rightPointer = sepPointer + 1;
        int tempPointer = startPointer;
        while (leftPointer <= sepPointer && rightPointer <= endPointer) {
            if (ends[leftPointer] < ends[rightPointer] ||
                    (ends[leftPointer] == ends[rightPointer] && starts[leftPointer] <= starts[rightPointer])) {
                startTmp[tempPointer] = starts[leftPointer];
                endTmp[tempPointer] = ends[leftPointer];
                leftPointer++;
            } else {
                startTmp[tempPointer] = starts[rightPointer];
                endTmp[tempPointer] = ends[rightPointer];
                rightPointer++;
            }
            tempPointer++;
        }
        while (leftPointer <= sepPointer) {
            startTmp[tempPointer] = starts[leftPointer];
            endTmp[tempPointer] = ends[leftPointer];
            leftPointer++;
            tempPointer++;
        }
        while (rightPointer <= endPointer) {
            startTmp[tempPointer] = starts[rightPointer];
            endTmp[tempPointer] = ends[rightPointer];
            rightPointer++;
            tempPointer++;
        }
        for (int i = startPointer; i <= endPointer; i++) {
            starts[i] = startTmp[i];
            ends[i] = endTmp[i];
        }
    }

}
