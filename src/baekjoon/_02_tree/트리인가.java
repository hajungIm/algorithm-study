package baekjoon._02_tree;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6416
 */

public class 트리인가 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer("");

        int k = 1;
        while (!isEnd) {
            ArrayList<int[]> input = new ArrayList<>();

            while (true) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if (start == -1 && end == -1) {
                    isEnd = true;
                    break;
                } else if (start == 0 && end == 0) {
                    break;
                } else {
                    input.add(new int[]{start, end});
                }
            }

            if (isEnd) {
                break;
            }

            if(isTree(input)) {
                sb.append(String.format("Case %d is a tree.\n", k++));
            } else {
                sb.append(String.format("Case %d is not a tree.\n", k++));
            }
        }

        System.out.println(sb);
    }

    private static ArrayList<int[]> getInput() throws IOException {
        ArrayList<int[]> result = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if (start == -1 && end == -1) {
                    isEnd = true;
                    flag = false;
                } else if (start == 0 && end == 0) {
                    flag = false;
                } else {
                    result.add(new int[]{start, end});
                }
            }
        }
        return result;
    }

    private static boolean isTree(ArrayList<int[]> arr) {
        Map<Integer, Integer> nodes = new HashMap<>();

        for (int[] n : arr) {
            nodes.put(n[0], nodes.getOrDefault(n[0], 0));
            nodes.put(n[1], nodes.getOrDefault(n[1], 0) + 1);
        }

        boolean isRoot = false;
        for (int value : nodes.values()) {
            if (value > 1 || (value == 0 && isRoot)) {
                return false;
            } else if (value == 0) {
                isRoot = true;
            }
        }
        return true;
    }
}
