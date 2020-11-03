import java.util.HashMap;

public class pro32 {

    static boolean[] network ;

    // 네트워크  - 문제에 반례 있음....but 프로그래머스 통과...
    public static void main(String[] args) {

        int[][] computers = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 1, 1 } };

        System.out.println(solution(4, computers));

    }

    static int solution(int n, int[][] computers) {

        int answer = 0;

        network = new boolean[n];

        for(int i = 0; i<n; i++){
            if (!network[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;

    }

    static void dfs(int[][] computers, int c){
        network[c] = true;

        for(int i = 0; i<computers.length; i++){
            if (c != i && computers[c][i] == 1 && !network[i]) {
               dfs(computers, i); 
               network[c] = network[i];
            }
        }
    }
}