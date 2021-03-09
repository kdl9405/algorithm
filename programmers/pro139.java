package programmers;

import java.util.*;


/* 
    문자열 내 마음대로 정렬하기

*/
public class pro139 {

    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = strings.clone();

            Arrays.sort(answer, (a1, a2) -> {

                if ((int) a1.charAt(n) == a2.charAt(n)) {
                    return a1.compareTo(a2);
                }

                return (int) a1.charAt(n) - a2.charAt(n);
            });
            return answer;
        }
    }
}
