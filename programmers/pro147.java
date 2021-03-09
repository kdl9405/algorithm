package programmers;

/* 
    이상한 문자 만들기

*/
public class pro147 {
    class Solution {
        public String solution(String s) {
            String[] str = s.split("");
            
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(String st : str) {
                if(st.equals(" ")){
                    count = 0;
                    sb.append(" ");
                    continue;
                }
                if(count == 0){
                    st = st.toUpperCase();
                    count++;
                }else{
                    st = st.toLowerCase();
                    count--;
                }
                sb.append(st);
            }
            
            String answer = sb.toString();
            return answer;
        }
    }
}