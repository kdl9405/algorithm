package BJ;

import java.io.*;
import java.util.*;

/* 
    가장 큰 정사각형
    시간초과
*/
public class BJ1915_copy {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for(int i = 0; i<n; i++){
            String line = br.readLine();
            for(int j = 0; j<m; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        int size = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if (arr[i][j] == '1') {

                   int x = 2;
                   while (true) {
                       if (!checkP(i, j, x)) {
                           size = Math.max(x-1, size);
                           break;
                       }
                       x++;
                   }                  
                }
            }
        }
        System.out.println(size*size);
    }

    static int n;
    static int m;
    static char[][] arr;

    static boolean checkP(int r, int c, int size){

        if (n - r < size || m-c < size ) {
            return false;
        }

        for(int i = r; i<r+size; i++){
            if (arr[i][c+size-1] == '0') {
                return false;
            }
        }

        for(int j = c; j<c+size; j++){
            if (arr[r+size-1][j] == '0') {
                return false;
            }
        }


        return true;
    }
}


