package programmers;

/* 
연습문제
연속 부분 수열 합의 개수
 */

import java.util.HashSet;
import java.util.Set;

public class pro252 {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> resultSet = new HashSet<>();

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    sum += elements[(start + i) % n];
                }
                resultSet.add(sum);
            }
        }
        return resultSet.size();
    }
}
