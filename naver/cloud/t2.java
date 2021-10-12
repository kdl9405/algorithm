package naver.cloud;

/* 
    창문닦기
    가능한 경로 중에서, 최대값 찾기
        1. (0,0)부터 시작하고 오른쪽 또는 아래방향으로만 진행가능
        2. 해당 칸에 가면 해당 값을 획득
        3. x방향, y방향에 따라 비용 발생.
        4. 가장 아랫줄에 도착했을 때, 최대 획득 값을 출력. 
        

    => 범위(1000*1000)가 크지 않아서, dfs로 해도 메모리,시간초과가 나지 않을것으로 판단.


    => but.
        1. xcost / ycost는 매번 계산할 필요 없이, 마지막 좌표값으로 한번에 계산가능!
        2. 결국 기존 costs배열 각 칸의 최대값을 dp로 저장?
        3. 
        findDP(int x, int y){

            if(dp[y][x] != 0){
                return dp[y][x];
            }

            return dp[y][x] = Math.max(fidnDP(y-1,x), findDP(y,x-1))+cost[y][x];
        }

        이렇게 dp를 적용? 하면 더 좋았을 듯.


*/

public class t2 {

    public static void main(String[] args) {

        int[][] costs = new int[10][10];
        int xcost = 2;
        int ycost = 2;

        System.out.println(solution2(costs, xcost, ycost));

    }

    public static int solution(int[][] costs, int xcost, int ycost) {

        max = 0;

        findValue(0, 0, 0, costs, xcost, ycost);

        if (max < 0) {
            max = 0;
        }

        System.out.println(count);

        return max;
    }

    static int max;
    static int dx[] = { 1, 0 };
    static int dy[] = { 0, 1 };
    static int count = 0;

    static void findValue(int y, int x, int v, int[][] costs, int xcost, int ycost) {

        // System.out.println(y+" "+x);
        count++;

        if (y == costs.length - 1 && x == costs[0].length - 1) {
            max = Math.max(max, v);
            return;
        }

        if (x + 1 < costs[0].length) {
            findValue(y, x + 1, v - xcost + costs[y][x + 1], costs, xcost, ycost);
        }

        if (y + 1 < costs.length) {
            findValue(y + 1, x, v - ycost + costs[y + 1][x], costs, xcost, ycost);
        }

        return;
    }

    public static int solution2(int[][] costs, int xcost, int ycost) {

        max = 0;

        dp = new int[costs.length][costs[0].length];
        visit = new boolean[costs.length][costs[0].length];


        int cost = ycost * (costs.length - 1);
        for (int i = 0; i < costs[0].length; i++) {
            max = Math.max(max, findDP(i, costs.length-1, costs) - cost);
            cost += xcost;
        }

        System.out.println(count);

        return max;
    }

    static int[][] dp;
    static boolean[][] visit;


    static int findDP(int x, int y, int[][] costs) {

        count++;

        if (visit[y][x]) {
            return dp[y][x];
        }

        visit[y][x] = true;

        if (y - 1 >= 0) {
            dp[y][x] = Math.max(findDP(y - 1, x, costs), dp[y][x]);
        }

        if (x - 1 >= 0) {
            dp[y][x] = Math.max(findDP(y, x - 1, costs), dp[y][x]);
        }

        return dp[y][x] = dp[y][x] + costs[y][x];
    }
}
