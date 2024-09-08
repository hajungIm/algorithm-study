package coding_test_study;

import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302?language=java
 */

public class w901_거리두기확인하기 {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        w901_거리두기확인하기_Solution solution = new w901_거리두기확인하기_Solution();
        int[] result = solution.solution(places);
        for (int res : result) {
            System.out.println(res);
        }
    }
}

class w901_거리두기확인하기_Solution {

    class Student {
        int x;
        int y;

        public Student(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int manhattan(Student s) {
            return Math.abs(this.x - s.x) + Math.abs(this.y - s.y);
        }
    }

    public int[] solution(String[][] places) {
        int n = places.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (isDistancing(places[i])) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    private boolean isDistancing(String[] place) {
        ArrayList<Student> students = findStudents(place);
        int num = students.size();
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (!obey(students.get(i), students.get(j), place)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean obey(Student s1, Student s2, String[] place) {
        int manhattan = s1.manhattan(s2);

        if (manhattan > 2) {
            return true;
        }

        if (manhattan == 2 && isPartition(s1, s2, place)) {
            return true;
        }

        return false;
    }

    private boolean isPartition(Student s1, Student s2, String[] place) {
        int minX = Math.min(s1.x, s2.x);
        int minY = Math.min(s1.y, s2.y);
        int maxX = Math.max(s1.x, s2.x);
        int maxY = Math.max(s1.y, s2.y);

        if (s1.x == s2.x && place[s1.x].charAt(minY + 1) == 'X') {
            return true;
        }

        if (s1.y == s2.y && place[minX + 1].charAt(s1.y) == 'X') {
            return true;
        }

        if (place[minX].charAt(maxY) == 'P' && place[maxX].charAt(minY) == 'P' &&
                place[minX].charAt(minY) == 'X' && place[maxX].charAt(maxY) == 'X') {
            return  true;
        }

        if (place[minX].charAt(minY) == 'P' && place[maxX].charAt(maxY) == 'P' &&
                place[minX].charAt(maxY) == 'X' && place[maxX].charAt(minY) == 'X') {
            return  true;
        }

        return false;
    }

    private ArrayList<Student> findStudents(String[] place) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    students.add(new Student(i, j));
                }
            }
        }
        return students;
    }

}
