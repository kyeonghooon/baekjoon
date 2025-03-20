package org.example.solv.marathon.course042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ParticipantList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        PriorityQueue<Student>[] classes = new PriorityQueue[N + 1];
        while (!input[0].equals("0")) {
            input = br.readLine().split(" ");
            int classId = Integer.parseInt(input[0]);
            String name = input[1];
            if (classes[classId] == null) {
                classes[classId] = new PriorityQueue<>();
            }
            if (classes[classId].size() >= M) continue;
            classes[classId].add(new Student(name));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i += 2) {
            if (classes[i] != null && !classes[i].isEmpty()) {
                while (!classes[i].isEmpty()) {
                    Student student = classes[i].poll();
                    sb.append(i).append(" ").append(student.name).append("\n");
                }
            }
        }
        for (int i = 2; i <= N; i += 2) {
            if (classes[i] != null && !classes[i].isEmpty()) {
                while (!classes[i].isEmpty()) {
                    Student student = classes[i].poll();
                    sb.append(i).append(" ").append(student.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}

class Student implements Comparable<Student> {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.name.length() == o.name.length()) {
            return this.name.compareTo(o.name);
        } else {
            return Integer.compare(this.name.length(), o.name.length());
        }
    }
}
