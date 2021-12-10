package programmers;

import java.util.Arrays;

/* 
    공 이동 시뮬레이션
*/
public class pro226_copy2 {

    public static void main(String[] args) {

        int[][] queries = { { 1, 1 } };

        System.out.println(solution(5, 5, 0, 1, queries));

    }

    private static long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;

        long[] row = new long[m];
        long[] col = new long[n];

        Arrays.fill(row, 1L);
        Arrays.fill(col, 1L);

        for (int i = 0; i < queries.length; i++) {

            System.out.println("!! "  + queries[i][0]);

            int dx = queries[i][1];

            switch (queries[i][0]) {
                case 0:

                    dx = Math.min(dx, m - 1);

                    for (int j = 1; j <= dx; j++) {
                        row[0] += row[j];
                        row[j] = 0;
                    }

                    for (int j = dx + 1; j < m; j++) {
                        row[j - dx] += row[j];
                        row[j] = 0;
                    }

                    break;

                case 1:

                    dx = Math.min(dx, m - 1);
                    
                    for (int j = m - 2; j >= m - 1 - dx; j--) {
                        row[m - 1] += row[j];
                        row[j] = 0;
                    }

                    for (int j = m - 2; j >= dx; j--) {
                        row[j] += row[j-dx];
                        row[j-dx] = 0;
                    }

                    break;
                case 2:

                    dx = Math.min(dx, n - 1);

                    for (int j = 1; j <= dx; j++) {
                        col[0] += col[j];
                        col[j] = 0;
                    }

                    for (int j = dx + 1; j < n; j++) {
                        col[j - dx] += col[j];
                        col[j] = 0;
                    }

                    break;
                case 3:

                    dx = Math.min(dx, n - 1);

                    for (int j = n - 2; j >= n - 1 - dx; j--) {
                        col[n - 1] += col[j];
                        col[j] = 0;
                    }

                    for (int j = n - 2; j >= dx; j--) {
                        col[j] += col[j - dx];
                        col[j - dx] = 0;
                    }

                    break;
            }

            for(int j = 0; j<m; j++){
                System.out.print(row[j]+" ");
            }
            System.out.println();
            for(int j = 0; j<n; j++){
                System.out.println(col[j]+" ");
            }
            System.out.println();
    
        }

        for(int i = 0; i<m; i++){
            System.out.print(row[i]+" ");
        }
        System.out.println();
        for(int i = 0; i<n; i++){
            System.out.println(col[i]+" ");
        }
        System.out.println();

        return answer = col[x] * row[y];

    }
}
