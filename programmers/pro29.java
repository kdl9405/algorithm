
//등굣길
public class pro29 {

    public static void main(String[] args) {

        int[][] puddles = {{3,5}, {5,8}, {8,8}};

        System.out.println(solution(10, 10, puddles));
    }

    static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {

            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;

        }

        int i = 1;
        for (int x = 0; x < n; x++) {
            if (map[x][0] == -1) {
                i = 0;
            }
            map[x][0] = i;
        }

        i = 1;
        for (int y = 1; y < m; y++) {
            if (map[0][y] == -1) {
                i = 0;
            }
            map[0][y] = i;
        }

        for (int x = 1; x < n; x++) {
            for (int y = 1; y < m; y++) {
                if (map[x][y] != 0) {
                    continue;
                }

                if (map[x - 1][y] == -1) {
                    map[x - 1][y] = 0;
                }
                if (map[x][y - 1] == -1) {
                    map[x][y - 1] = 0;
                }

                map[x][y] = (map[x - 1][y] + map[x][y - 1]) % 1000000007;
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println("");
        }

        return (map[n - 1][m - 1]);
    }
}