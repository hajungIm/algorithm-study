package swmaster;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/1924
 */

public class 이천칠년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int days = 0;

        for (int i = 1; i <= x - 1; i++) {
            days += findMonth(i);
        }
        days += y;

        System.out.println(findWeekday(days % 7));
    }

    private static int findMonth(int x) {
        if (x == 2) {
            return 28;
        }
        if (x == 4 || x == 6 || x == 9 || x == 11) {
            return 30;
        }
        return 31;
    }

    private static String findWeekday(int x) {
        if (x == 1) {
            return "MON";
        }
        if (x == 2) {
            return "TUE";
        }
        if (x == 3) {
            return "WED";
        }
        if (x == 4) {
            return "THU";
        }
        if (x == 5) {
            return "FRI";
        }
        if (x == 6) {
            return "SAT";
        }
        return "SUN";
    }
}
