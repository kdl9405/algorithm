package programmers;

/* 
    문자열 다루기 기본

*/
public class pro136 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            
            if(s.length() !=4 && s.length()!=6){
                answer = false;
            }else{           
            
            
            String n = s.replaceAll("[^0-9]","");
            
            if(n.length() != s.length()){
                answer = false;
            }
            }
            
            return answer;
        }
    }
}
