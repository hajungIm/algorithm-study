package baekjoon._05_dp1;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10870
 */

public class 피보나치수5 {

    static Integer[] dp = new Integer[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(find(n));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = find(n - 1) + find(n - 2);
        }
        return dp[n];
    }
}
