package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667
 */

public class 단지번호붙이기 {

    static int N;
    static int cnt;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static int d[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (board[i][j] == 1) {
                        cnt = 1;
                        dfs(i, j);
                        result.add(cnt);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');

        Collections.sort(result);
        for (Integer i : result) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + d[i][0];
            int dy = y + d[i][1];

            if (dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dx][dy]) {
                continue;
            }
            visited[dx][dy] = true;

            if (board[dx][dy] == 1) {
                cnt++;
                dfs(dx, dy);
            }
        }
    }
}
