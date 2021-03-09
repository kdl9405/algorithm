package programmers;

/* 
    정수 제곱근 판별

*/
public class pro151 {
    class Solution {
        public long solution(long n) {
            long answer = -1;
            
            double d = n;
            
            double s = Math.sqrt(d);
            if(Math.pow((long)s, 2) == d){
                answer = (long)Math.pow(s+1,2);
            }
            
            return answer;
        }
    }
}
