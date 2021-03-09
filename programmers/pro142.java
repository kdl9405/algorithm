package programmers;

/* 
    수박수박수박수박수박수?

*/
public class pro142 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            
            int x = n/2;
            
            StringBuffer sb = new StringBuffer();
            while(x-- > 0){
                sb.append("수박");
            }
            if(n%2 == 1){
                sb.append("수");
            }
            
            answer = sb.toString();
            
            return answer;
        }
    }
}
