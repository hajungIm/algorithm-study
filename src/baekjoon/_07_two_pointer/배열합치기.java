package baekjoon._07_two_pointer;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11728
 */

public class 배열합치기 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> result = sort(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static ArrayList<Integer> sort(int[] A, int[] B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < N || j < M) {
            if (i < N && j < M) {
                if (A[i] <= B[j]) {
                    result.add(A[i++]);
                } else {
                    result.add(B[j++]);
                }
            } else if (i < N) {
                result.add(A[i++]);
            } else {
                result.add(B[j++]);
            }
        }

        return result;
    }
}
