package naver.cloud;

public class t2 {

    public static void main(String[] args) {

    }

    public static int solution(int[][] costs, int xcost, int ycost) {

        max = 0;

        findValue(0, 0, 0, costs, xcost, ycost);

        if (max < 0) {
            max = 0;
        }


        return max;
    }

    static int max;
    static int dx[] = { 1, 0 };
    static int dy[] = { 0, 1 };

    static void findValue(int y, int x, int v, int[][] costs, int xcost, int ycost) {

        if (y == costs.length-1 && x == costs[0].length-1) {
            max = Math.max(max, v);
            return;
        }

        if (y + 1 < costs.length) {
            findValue(y + 1, x, v - ycost + costs[y + 1][x], costs, xcost, ycost);
        }

        if (x + 1 < costs[0].length) {
            findValue(y, x + 1, v - xcost + costs[y][x + 1], costs, xcost, ycost);
        }

        return;
    }
}
