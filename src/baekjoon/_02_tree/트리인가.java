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
        int cnt = 1;

        while (true) {
            ArrayList<int[]> input = getInput();
            if (isEnd) {
                break;
            }

            if (isTree(input)) {
                sb.append(String.format("Case %d is a tree.", cnt++)).append('\n');
            } else {
                sb.append(String.format("Case %d is not a tree.", cnt++)).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static ArrayList<int[]> getInput() throws IOException {
        ArrayList<int[]> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == 0) {
                break;
            }
            if (u == -1) {
                isEnd = true;
                break;
            }

            result.add(new int[]{u, v});
        }
        return result;
    }

    private static boolean isTree(ArrayList<int[]> inputs) {
        if (inputs.size() == 0) {
            return true;
        }

        Set<Integer> income = new HashSet<>();
        Set<Integer> nodes = new HashSet<>();
        for (int[] input : inputs) {
            // 루트 제외 모든 노드 단 하나의 들어오는 간선
            if (!income.add(input[1])) {
                return false;
            }
            nodes.add(input[0]);
            nodes.add(input[1]);
        }
        // 전체 노드 수 - 1 == 간선 수 만족해야지 트리
        if (nodes.size() - 1 == income.size()) {
            return true;
        }
        return false;
    }
}
