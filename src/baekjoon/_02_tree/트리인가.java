package baekjoon._02_tree;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6416
 */

public class 트리인가 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int k = 0;
        while (true) {
            ArrayList<int[]> input = getInput();
            isTree(input);
        }
    }

    private static ArrayList<int[]> getInput() throws IOException {
        ArrayList<int[]> result = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            String[] input = br.readLine().split(" ");
            int tmp = 0;
            for (int i = 0; i < input.length; i++) {
                if (i % 0 == 0) {
                    tmp = Integer.parseInt(input[i]);
                } else {
                    if (tmp == 0 && Integer.parseInt(input[i]) == 0) {
                        flag = false;
                    } else {
                        result.add(new int[]{tmp, Integer.parseInt(input[i])});
                    }
                }
            }
        }
        return result;
    }

    private boolean isTree(ArrayList<int[]> arr) {
        Set<Integer> income = new HashSet<>();

        for (int[] input : arr) {

        }
        return true;
    }
}
