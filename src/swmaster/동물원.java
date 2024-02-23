package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1309
 */

public class 동물원 {

    static int MOD = 9901;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][3];
        Arrays.fill(dp[1], 1L);

        System.out.println(find());
    }

    private static long find() {
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        long result = 0L;
        for (int i = 0; i < 3; i++) {
            result += dp[N][i];
        }
        return result % MOD;
    }
}
