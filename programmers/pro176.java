package programmers;


/* 
    3 x n 타일링

*/
public class pro176 {
    
    public int solution(int n) {
        int answer = 0;
            
        dp = new long[(n/2)+1];
        dp[0] = 1;
        dp[1] = 3;
    
        answer = (int)findDP(n/2);
        
            
        return answer;
    }
    
    static long[] dp;
    
    static long findDP(int n){
        if(dp[n] != 0){
            return dp[n];
        }
        
        for(int i = 0; i<n-1; i++){
            dp[n] += (2*findDP(i));
        }
        
        dp[n] = (findDP(n-1)*3 + dp[n])%1000000007;
        
        return dp[n];
    }
}
