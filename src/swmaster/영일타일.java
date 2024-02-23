package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/1904
 */

public class 영일타일 {

    static int MOD = 15746;
    static Long dp[] = new Long[1000001];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        if (N <= 2) {
            System.out.println(dp[N]);
            return;
        }

        System.out.println(find(N));
    }

    private static Long find(int n) {
        if (dp[n] == null) {
            dp[n] = (find(n - 1) + find(n - 2)) % MOD;
        }
        return dp[n];
    }
}
