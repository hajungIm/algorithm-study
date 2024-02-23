package swmaster;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1697
 */

public class 숨바꼭질 {

    static int K;
    static int LIMIT = 200000;
    static Integer[] dp = new Integer[LIMIT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(find(N));
    }

    private static int find(int n) {
        Deque<Integer> q = new LinkedList<>();

        q.offer(n);
        dp[n] = 0;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (now == K) {
                return dp[now];
            }

            if (now * 2 < LIMIT && dp[now * 2] == null) {
                dp[now * 2] = dp[now] + 1;
                q.offer(now * 2);
            }
            if (now - 1 >= 0 && dp[now - 1] == null) {
                dp[now - 1] = dp[now] + 1;
                q.offer(now - 1);
            }
            if (now + 1 < LIMIT && dp[now + 1] == null) {
                dp[now + 1] = dp[now] + 1;
                q.offer(now + 1);
            }
        }
        return dp[K];
    }
}
