package baekjoon._04_greedy;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14916
 */

public class 거스름돈 {

    static final int TWO = 2;
    static final int FIVE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int fiveMax = n / FIVE;
        for (int i = fiveMax; i >= 0; i--) {
            int ans = i;
            int rest = n - i * FIVE;
            if (rest % TWO != 0) {
                continue;
            }

            ans += rest / TWO;
            System.out.println(ans);
            return;
        }

        System.out.println(-1);
    }
}
