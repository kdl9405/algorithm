package programmers;

/* 
    문자열 내 p와 y의 개수

*/
public class pro137 {

    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            s = s.toUpperCase();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'P') {
                    count++;
                } else if (s.charAt(i) == 'Y') {
                    count--;
                }
            }
            if (count != 0) {
                answer = false;
            }

            return answer;
        }
    }
}
