package baekjoon._08_implementation;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21608
 */

public class 상어초등학교 {

    static class Seat {
        int x;
        int y;
        int likedCnt;
        int emptyCnt;

        public Seat(int x, int y, int likedCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.likedCnt = likedCnt;
            this.emptyCnt = emptyCnt;
        }

        public Seat compare(Seat seat) {
            if (this.likedCnt > seat.likedCnt) {
                return this;
            } else if (this.emptyCnt > seat.emptyCnt) {
                return this;
            } else if (this.x < seat.x) {
                return this;
            } else if (this.y < seat.y) {
                return this;
            }
            return seat;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] student = new int[N * N];
        HashMap<Integer, Set<Integer>> liked = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[i] = Integer.parseInt(st.nextToken());
            liked.put(student[i], new HashSet<>());
            for (int j = 0; j < 4; j++) {
                liked.get(student[i]).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] map = new int[N * N][N * N];

        for (int i = 0; i < N * N; i++) {
            Seat seat = findSeat(students[i]);
        }
    }

    private static Seat findSeat(int student) {

    }
}
