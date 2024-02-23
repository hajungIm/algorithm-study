package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2293
 */

public class 동전1 {

    static int n, k;
    static int dp[];
    static int coin[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        dp = new int[k + 1];
        dp[0] = 1;
        find();

        System.out.println(dp[k]);
    }

    private static void find() {
        for (int c : coin) {
            for (int i = c; i <= k; i++) {
                dp[i] = dp[i] + dp[i - c];
            }
        }
    }
}
