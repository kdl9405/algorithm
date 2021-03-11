package programmers;


/* 
    네트워크
*/
public class pro172 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean[] visit;
    
    static void dfs(int x, int[][] computers){
        
        for(int i = 0; i<computers.length ; i++){
            if(i == x){
                continue;
            }
            if(computers[x][i]== 1 && !visit[i]){
                visit[i] = true;
                dfs(i, computers);
            }
        }
        
        return;
    }
    
}

