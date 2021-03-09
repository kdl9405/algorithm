package programmers;

import java.util.Arrays;

/* 
    문자열 내림차순으로 배치하기

*/
public class pro140 {

    class Solution {
        public String solution(String s) {
            String answer = "";
                
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
        
            StringBuilder sb = new StringBuilder(new String(arr));
            sb.reverse();
            answer = sb.toString();
            
            return answer;
        }
    }
}
