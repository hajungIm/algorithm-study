package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11057
 */

public class 오르막수 {

    static int MOD = 10007;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N][11];
        Arrays.fill(dp[0], 1L);

        System.out.println(find());
    }

    private static long find() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        long sum = 0L;
        for (int i = 1; i <= 10; i++) {
            sum = (sum + dp[N - 1][i]) % MOD;
        }
        return sum % MOD;
    }
}
