package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 */

public class DFS와BFS {

    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int S = Integer.parseInt(input[2]);

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int u = Integer.parseInt(input[1]);
            graph[v].add(u);
            graph[u].add(v);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        sb.append(S).append(" ");
        visited[S] = true;
        dfs(S);
        sb.append('\n');

        bfs(S);

        System.out.println(sb);
    }

    private static void dfs(int n) {
        for (Integer next : graph[n]) {
            if (!visited[next]) {
                visited[next] = true;
                sb.append(next).append(" ");
                dfs(next);
            }
        }
    }

    private static void bfs(int S) {
        visited = new boolean[N + 1];
        Deque<Integer> q = new LinkedList<>();
        visited[S] = true;
        q.add(S);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            sb.append(now).append(" ");

            for (Integer next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
