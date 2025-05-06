package org.example.solv.marathon.course047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Computer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            int[] memory = new int[32];
            memory[0] = Integer.parseInt(line, 2);
            for (int i = 1; i < 32; i++) {
                memory[i] = Integer.parseInt(br.readLine(), 2);
            }
            int acc = 0, pc = 0;

            while (true) {
                int instr = memory[pc] & 0xFF;
                int opcode = instr >> 5;
                int operand = instr & 0x1F;
                pc = (pc + 1) & 0x1F;

                switch (opcode) {
                    case 0:
                        memory[operand] = acc & 0xFF;
                        break;
                    case 1:
                        acc = memory[operand] & 0xFF;
                        break;
                    case 2:
                        if (acc == 0) pc = operand;
                        break;
                    case 3:
                        break;
                    case 4:
                        acc = (acc - 1) & 0xFF;
                        break;
                    case 5:
                        acc = (acc + 1) & 0xFF;
                        break;
                    case 6:
                        pc = operand;
                        break;
                    case 7:
                        sb.append(String.format("%8s", Integer.toBinaryString(acc & 0xFF)).replace(' ', '0')).append("\n");
                        break;
                }
                if (opcode == 7) break;
            }
        }
        System.out.println(sb);
    }
}
