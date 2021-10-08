package programmers;

import java.util.*;

/* 
    스타 수열

    no IDE
*/
public class pro219 {

    public int solution(int[] a) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : a) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            if (answer >= map.get(n)) {
                continue;
            }

            int count = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == n || a[i + 1] == n) {
                    if (a[i] != a[i + 1]) {
                        count++;
                        i++;
                    }
                }
            }

            answer = Math.max(answer, count);

        }

        answer *= 2;
        return answer;
    }

}
