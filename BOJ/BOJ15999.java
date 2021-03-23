package BOJ;

import java.io.*;
import java.util.*;

/* 
    뒤집기 
*/
public class BOJ15999 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
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

        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if (check(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(calculator(count));

    }  
    
    static int n,m;
    static char[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static boolean check(int x, int y){

        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx>=0 && nx<n && ny>=0 && ny<m) {
                if (arr[x][y] != arr[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }

    static long calculator(int count){
        if (count == 1) {
            return 2;
        }

        if (count % 2 == 1) {
            long temp = calculator(count-1);
            return (2*temp) % 1000000007;
        }else {
            long temp = calculator(count/2);
            return (temp*temp) % 1000000007;
        }

    } 
}
