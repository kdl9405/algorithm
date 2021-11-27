package programmers;

import java.util.Arrays;

/* 
    공 이동 시뮬레이션
*/
public class pro226 {

    public static void main(String[] args) {

    }

    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;

        long[] row = new long[m];
        long[] col = new long[n];

        Arrays.fill(row, 1L);
        Arrays.fill(col, 1L);

        for (int i = queries.length - 1; i >= 0; i--) {

            int dx = queries[i][1];

            switch (queries[i][0]) {
            case 0:
                for (int j = m - 1; j >= 0; j--) {

                    if (row[j] == 0) {
                        continue;
                    }
                    // int nj = Math.min(m - 1, j + dx);
                    // if (j != nj) {
                    //     row[nj] += row[j];
                    //     row[j] = 0;
                    // }

                    int nj = j+dx;
                    if (condition) {
                        
                    }


                }
                break;

            case 1:

                for (int j = 0; j < m; j++) {
                    if (row[j] == 0) {
                        continue;
                    }

                    int nj = Math.max(0, j - dx);
                    if (j != nj) {
                        row[nj] += row[j];
                        row[j] = 0;
                    }
                }

                break;
            case 2:

                for (int j = n - 1; j >= 0; j--) {
                    if (col[j] == 0) {
                        continue;
                    }
                    int nj = Math.min(n - 1, j + dx);
                    if (j != nj) {
                        col[nj] += col[j];
                        col[j] = 0;
                    }
                }

                break;
            case 3:
                for (int j = 0; j < n; j++) {
                    if (col[j] == 0) {
                        continue;
                    }

                    int nj = Math.max(0, j - dx);
                    if (j != nj) {
                        col[nj] += col[j];
                        col[j] = 0;
                    }
                }

                break;
            }
        }

        for(int i = 0; i<m; i++){
            System.out.print(row[i]+" ");
        }
        System.out.println();
        for(int i = 0; i<n; i++){
            System.out.println(col[i]+" ");
        }

        return answer = col[x] * row[y];

    }
}
