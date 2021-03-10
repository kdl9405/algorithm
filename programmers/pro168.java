package programmers;


/* 
    스티커 모으기(2)

*/
public class pro168 {
    public int solution(int sticker[]) {
        int answer = 0;
        
        N = sticker.length;
        if(N == 1){
           return sticker[0];
        }
        
        if(N == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        dp = new int[N][2]; // [0] 1번선택  // [1] 1번 선택 x
    
        dp[0][0] = sticker[0];
        dp[1][0] = Math.max(sticker[0], sticker[1]); 
        dp[0][1] = 0; 
        dp[1][1] = sticker[1];
        
        answer = Math.max(findDP(sticker,N-2,0), findDP(sticker, N-3,1)+sticker[N-1]);
        
        return answer;
    }
    
    static int[][] dp;
    static int N;
    
    
    static int findDP(int[] sticker, int n, int c){
        
        if(n <= 1){
            return dp[n][c];
        }
                
        if(dp[n][c] != 0){
            return dp[n][c];
        }
        
        dp[n][c] = Math.max(findDP(sticker, n-2,c)+sticker[n], findDP(sticker, n-1,c));
                
        return dp[n][c];
    }

}
