package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/2606
 */

public class w901_바이러스 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);

        System.out.println(count(n));
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (Integer next : graph[node]) {
            if (visited[next]) {
                continue;
            }

            dfs(next);
        }
    }

    private static int count(int n) {
        int ans = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                ans++;
            }
        }
        return ans;
    }
}
