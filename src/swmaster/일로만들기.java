package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/1463
 */

public class 일로만들기 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[1] = 0;

        System.out.println(find(N));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(find(n / 3), Math.min(find(n / 2), find(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(find(n / 3), find(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(find(n / 2), find(n - 1)) + 1;
            } else {
                dp[n] = find(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
