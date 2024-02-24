package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15649
 */

public class N과M_1 {

    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];
        ArrayList<Integer> trace = new ArrayList<>();
        find(trace);

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> arr : result) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void find(ArrayList<Integer> trace) {
        if (trace.size() == M) {
            result.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                trace.add(i);
                find(trace);

                visited[i] = false;
                trace.remove(trace.size() - 1);
            }
        }
    }
}
