package programmers;


/* 
    최대공약수와 최소공배수

*/
public class pro154 {

    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
    
            int d = GCD(n,m);
            answer[0] = d;
            answer[1] = (n*m)/d;
            
            return answer;
        }
        
        static int GCD(int n, int m){
            if(n < m){
                int temp = n;
                n = m;
                m = temp;
            }
            while(m != 0){
                int x = n%m;
                n = m;
                m = x;
            }
            
            return n;
        }
    }
    
}
