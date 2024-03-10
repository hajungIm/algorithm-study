package baekjoon._03_math;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1978
 */

public class 소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (isPrime(n)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
