package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/1149
 */

public class RGB거리 {

    static Integer[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]);
            cost[i][1] = Integer.parseInt(input[1]);
            cost[i][2] = Integer.parseInt(input[2]);
        }

        dp = new Integer[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(find(N - 1, 0), Math.min(find(N - 1, 1), find(N - 1, 2))));
    }

    private static int find(int n, int color) {
        if (dp[n][color] == null) {
            dp[n][color] = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (color == i) {
                    continue;
                }
                dp[n][color] = Math.min(dp[n][color], find(n - 1, i) + cost[n][color]);
            }
        }
        return dp[n][color];
    }
}
