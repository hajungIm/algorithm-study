package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/9095
 */

public class 일이삼_더하기 {

    static Integer[] dp = new Integer[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(find(n)).append('\n');
        }

        System.out.println(sb);
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = find(n - 1) + find(n - 2) + find(n - 3);
        }
        return dp[n];
    }
}
