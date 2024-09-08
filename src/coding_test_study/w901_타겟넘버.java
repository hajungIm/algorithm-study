package coding_test_study;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */

public class w901_타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        w901_타겟넘버_Solution solution = new w901_타겟넘버_Solution();
        int ans = solution.solution(numbers, target);
        System.out.println(ans);
    }
}

class w901_타겟넘버_Solution {
    static int[] numbers;
    static int target;
    static int size;
    static int ans = 0;

    public int solution(int[] numbersInput, int targetInput) {
        numbers = numbersInput;
        target = targetInput;
        size = numbers.length;

        backtrack(0, 0);

        return ans;
    }

    private void backtrack(int num, int idx) {
        if (idx == size) {
            if (num == target) {
                ans++;
            }
            return;
        }

        backtrack(num + numbers[idx], idx + 1);
        backtrack(num - numbers[idx], idx + 1);
    }
}