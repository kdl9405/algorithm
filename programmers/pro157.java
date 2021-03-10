package programmers;


/* 
    하샤드 수

*/
public class pro157 {
    class Solution {
        public boolean solution(int x) {
            boolean answer = true;
            
            int y = x;
            int sum = 0;
            while(y>0){
                sum +=(y%10);
                y/=10;
            }
            
            if(x % sum != 0){
                answer = false;
            }
            
            return answer;
        }
    }    
}
