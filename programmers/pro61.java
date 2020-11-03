/**
 * pro61
 */
public class pro61 {

    public static void main(String[] args) {

        int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
        int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };

    }

    static int[][] solution(int[][] arr1, int[][] arr2) {

        int n = arr1.length;
        int m = arr2[0].length;
        int len = arr2.length;

        int[][] answer = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                for(int x = 0; x<len; x++){
                    answer[i][j] += arr1[i][x]*arr2[x][j];
                }
            }
        }

        return answer;
    }
}