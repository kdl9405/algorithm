package programmers;

/* 
    정수 삼각형
*/

public class pro209 {

    public static void main(String[] args) {
        
    }
    
    public int solution(int[][] triangle) {
        int answer = 0;
            
        map = triangle.clone();
        visit = new boolean[triangle.length][triangle.length];
                
        answer = findMax(0,0);
        
        return answer;
    }
    
    static int[][] map;
    static boolean[][] visit;
    
    static int findMax(int r, int c){
        
        if(r >= map.length || c>r){
            return 0;
        }
        
        if(visit[r][c]){
            return map[r][c];
        }
        
        visit[r][c] = true;
        
        return map[r][c] += Math.max(findMax(r+1,c), findMax(r+1,c+1));
        
    }
}
