package baekjoon._08_implementation;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21608
 */

public class 상어초등학교 {
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


    }
}
