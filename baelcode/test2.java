import java.util.HashMap;

public class test2 {
    public static void main(String[] args) {
        int N = 7;
        int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
        String[] dirname = {"root","abcd","cs","hello","etc","hello","solution"};

        System.out.println(solution(N, relation, dirname));
    }

    static int solution(int N, int[][] relation, String[] dirname) {
        int answer = 0;

       map = new HashMap<>();
        for(int[] r : relation){
            map.put(r[1], r[0]);
        }
        dp = new int[N+1];
        dp[1] = dirname[0].length();



        for(int i = 1; i<=N; i++){
            answer = Math.max(answer, findDP(i,dirname));
        }
        return answer;
    }

    static int[] dp;
    static HashMap<Integer,Integer> map;

    static int findDP(int n, String[] dirname){

        if (n == 1) {
            return dp[n];
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = findDP(map.get(n), dirname) + 1 + dirname[n-1].length();
        return dp[n];
    }
}
