/**
 * 보행자 천국
    테케 O 히든 X
 */
public class pro86_copy {

    public static void main(String[] args) {

        int[][] cityMap = { {0,0,0},{0,0,0},{0,0,0} };
        int m = 3;
        int n = 3;

        System.out.println(solution(m, n, cityMap));

    }

    static int MOD = 20170805;

    static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] map = new int[m][n];
        
        map[0][0] = 1;
        for(int i = 0; i<m; i++){
            if(i == 0){                
                for(int j = 1; j<n; j++){
                    if(cityMap[i][j] == 1){
                        break;
                    }
                    map[i][j] = 1;
                }
            }else {
                if(cityMap[i][0] == 1){
                    break;
                }
                map[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                if (cityMap[i][j] == 1) {
                    continue;
                }

                if (cityMap[i][j] == 2) {
                    if (i < m - 1) {
                        map[i][j] += map[i - 1][j];
                    }
                    if (j < n - 1) {
                        map[i][j] += map[i][j - 1];
                    }
                }

                if (cityMap[i][j] == 0) {
                    if (cityMap[i - 1][j] == 2) {
                        if (i > 1) {
                            map[i][j] += map[i - 2][j];
                        }
                    } else {
                        map[i][j] += map[i - 1][j];
                    }

                    if (cityMap[i][j - 1] == 2) {
                        if (j > 1) {
                            map[i][j] += map[i][j - 2];
                        }
                    } else {
                        map[i][j] += map[i][j - 1];
                    }
                }

            }
        }

        answer = map[m-1][n-1] % MOD; 

        return answer;
    }
}