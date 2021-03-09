package programmers;


/* 
    소수 찾기

*/
public class pro141 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            
            boolean[] prime = new boolean[n+1]; // false:소수 / true = 소수아님
            for(int i = 2; i<=n; i++){
                if(!prime[i]){
                    answer ++;
                    
                    for(int j = 2; j*i<=n; j++){
                        prime[i*j] = true;
                    }
                }
            }
            
            
            return answer;
        }
    }
}
