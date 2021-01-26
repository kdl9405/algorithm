package programmers;

/* 
2017 카카오코드 본선
GPS

1. 시작에서 끝점까지의 모든 경로 구함
2. gps_log 와 각 경로 비교 (경로의 길이 <=  log의 k) 
3. 차이의 최소값을 출력
4. 만약 시작-끝 경로가 존재하지 않으면 -1
 */

 // 시간초과

public class pro119_copy {

    public static void main(String[] args) {

        int n = 7;
        int m = 10;
        int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
                { 6, 7 } };
        int k = 6;
        int[] gps_log = { 1, 2, 3, 3, 6, 7 };

        System.out.println(solution(n, m, edge_list, k, gps_log));

    }

    static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        road = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            road[edge_list[i][0]][edge_list[i][1]] = true;
            road[edge_list[i][1]][edge_list[i][0]] = true;
        }
        for (int i = 1; i <= n; i++) {
            road[i][i] = true;
        }

        int start = gps_log[0];
        int fin = gps_log[k - 1];

        dif = gps_log.length+1;
        root = new int[k];
        root[0] = start;
        log = gps_log.clone();

        dfs(start, fin, 1, k);

        if (dif == gps_log.length+1) {
            dif = -1;
        }

        return dif;
    }

    static boolean[][] road;
    static int dif;
    static int[] root;
    static int[] log;

    static void dfs(int start, int fin, int depth, int k) {

        if (depth == k) {
            // 차이 계산
            if (root[k - 1] == fin) {
                dif = Math.min(dif, checkDiff(root));
            }

            return;
        }

        for (int i = 1; i < road.length; i++) {
            if (road[start][i]) {
                root[depth] = i;
                dfs(i, fin, depth + 1, k);
            }
        }
    }

    static int checkDiff(int[] root) {

        int count = 0;

        for (int i = 1; i < log.length-1; i++) {
            if (log[i] != root[i]) {
                count++;
                if (count >= dif) {
                    break;
                }
            }
        }

        return count;
    }
}
