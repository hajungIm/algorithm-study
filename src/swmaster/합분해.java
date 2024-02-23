package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2225
 */

public class 합분해 {

    static int MOD = 1000000000;
    static int N, K;
    static long dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new long[K + 1][N + 1];
        Arrays.fill(dp[1], 1L);
        for (int i = 0; i < K + 1; i++) {
            dp[i][0] = 1;
        }

        System.out.println(find());
    }

    private static long find() {
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return dp[K][N];
    }
}
