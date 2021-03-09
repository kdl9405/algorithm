package programmers;

/* 
    짝수와 홀수

*/
public class pro153 {
    class Solution {
        public String solution(int num) {
            String answer = "Even";
            
            if(num %2 != 0){
                answer = "Odd";
            }
            
            return answer;
        }
    }
}
