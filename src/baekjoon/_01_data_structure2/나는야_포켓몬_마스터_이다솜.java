package baekjoon._01_data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1620
 */

public class 나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nameToNum.put(pokemon, i);
            numToName[i] = pokemon;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (parseInt(s)) {
                sb.append(numToName[Integer.parseInt(s)]).append('\n');
            } else {
                sb.append(nameToNum.get(s)).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean parseInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
