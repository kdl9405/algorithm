package programmers;

/**
 * N-Queen
 * 
 */
public class pro101 {

    public static void main(String[] args) {

        System.out.println(solution(4));
    }

    static int solution(int n) {
        int answer = 0;

        map = new int[n][n];
        visit = new boolean[n];

        check(0, n);

        answer = count;

        return answer;
    }

    static int[][] map;
    static boolean[] visit;
    static int count = 0;

    static void check(int i, int n) {
        if (i == n) {
            count++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!visit[j]) {
                boolean possbile = true;
                if (i != 0) {
                    for (int x = 1; i - x >= 0; x++) {
                        if (j-x>=0 && map[i - x][j - x] == 1) {
                            possbile = false;
                            break;
                        }
                        if (j+x<n && map[i - x][j + x] == 1) {
                            possbile = false;
                            break;
                        }
                        if (j - x < 0 && j + x >= n) {
                            break;
                        }
                    }
                }
                if (possbile) {
                    visit[j] = true;
                    map[i][j] = 1;
                    check(i + 1, n);
                    map[i][j] = 0;
                    visit[j] = false;
                }

            }
        }

    }
}