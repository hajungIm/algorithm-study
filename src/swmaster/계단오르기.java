package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/2579
 */

public class 계단오르기 {

    static int[] stair;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stair = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = stair[1];
        if (N == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = stair[1] + stair[2];

        System.out.println(find(N));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = stair[n] + Math.max(stair[n - 1] + find(n - 3), find(n - 2));
        }
        return dp[n];
    }
}
