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
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }

        dp = new Long[n + 1];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 3L;

        System.out.println(find(n));
    }

    private static Long find(int n) {
        if (dp[n] == null) {
            dp[n] = (find(n - 1) + find(n - 2)) % mod;
        }
        return dp[n];
    }
}
