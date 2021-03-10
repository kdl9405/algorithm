package programmers;


/* 
    콜라츠 추측

*/
public class pro155 {
    class Solution {
        public int solution(int num) {
                   
            int answer = 0;
            
            if(num != 1){
                
                    long n = (long)num;
            int count = 500;
            while(count-- > 0){
                if(n % 2 == 0){
                    n/=2;
                }else {
                    n*=3;
                    n++;
                }
                
                if(n == 1){                
                    break;
                }
            }
            
            if(n != 1){
                answer = -1;
            }else {
                answer = 500-count;
            }
            }
            
            return answer;
        }
    }

}
