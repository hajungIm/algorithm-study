package baekjoon._00_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/10828
 */

public class 스택 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> stack = new ArrayList<>();
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void push(int X) {
        stack.add(idx++, X);
    }

    private static void pop() {
        if (idx == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(stack.get(idx - 1)).append('\n');
        idx--;
    }

    private static void size() {
        sb.append(idx).append('\n');
    }

    private static void empty() {
        if (idx == 0) {
            sb.append("1\n");
            return;
        }
        sb.append("0\n");
    }

    private static void top() {
        if (idx == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(stack.get(idx - 1)).append('\n');
    }
}
