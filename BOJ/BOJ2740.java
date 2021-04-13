package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2740 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] b = new int[m][k];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<k; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n][k];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<k; j++){
                for(int x = 0; x<m; x++){
                    result[i][j] += a[i][x] * b[x][j];
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<k; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }


    }
}
