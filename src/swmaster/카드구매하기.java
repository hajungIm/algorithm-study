package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/11052
 */

public class 카드구매하기 {

    static int N;
    static int[] cost;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cost = new int[N + 1];
        dp = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(input[i - 1]);
        }

        find();

        System.out.println(dp[N]);
    }

    private static void find() {
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], cost[i] + dp[j - i]);
            }
        }
    }
}
