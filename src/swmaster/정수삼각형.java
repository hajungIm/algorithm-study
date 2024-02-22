package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/1932
 */

public class 정수삼각형 {

    static Integer[][] dp;
    static int[][] num;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                num[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = num[n - 1][i];
        }

        System.out.println(find(0, 0));
    }

    private static int find(int n, int m) {
        if (dp[n][m] == null) {
            dp[n][m] = Math.max(find(n + 1, m), find(n + 1, m + 1)) + num[n][m];
        }
        return dp[n][m];
    }
}
