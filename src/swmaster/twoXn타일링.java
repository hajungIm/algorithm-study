package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/11726
 */

public class twoXn타일링 {

    static Long[] dp;
    static final Long mod = 10007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
        }

        dp = new Long[n + 1];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;

        System.out.println(find(n));

    }

    private static Long find(int n) {
        if (dp[n] == null) {
            if (n % 2 == 1) {
                dp[n] = (find(n - 1) + find(n - 2)) % mod;
            } else {
                dp[n] = (2 * find(n - 2) + 1) % mod;
            }
        }
        return dp[n];
    }
}
