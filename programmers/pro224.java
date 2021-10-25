package programmers;


/* 
    12주차  
    피로도
*/

public class pro224 {
    public int solution(int k, int[][] dungeons) {
        answer = 0;

        visit = new boolean[dungeons.length];
        
        dfs(k,0,dungeons);

        return answer;
    }

    static int answer;
    static boolean[] visit;

    static void dfs(int k, int depth, int[][] dungeons) {

        if (answer < depth) {
            answer = depth;
           
        }
        
        

        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] || k < dungeons[i][0]) {
                continue;
            }

            visit[i] = true;
            dfs(k - dungeons[i][1], depth + 1, dungeons);
            visit[i] = false;

        }

    }
}