package programmers;

import java.util.*;

/* 
    예산

*/
public class pro162 {

    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            Arrays.sort(d);

            for (int x : d) {
                budget -= x;
                if (budget < 0) {
                    break;
                }
                answer++;
            }

            return answer;
        }
    }
}
