package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1992 {
    
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i = 0 ;i<n; i++){
            String s = br.readLine();
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));                
            }
        }

        check_arr(0, 0, n);

        System.out.println(sb);

    }

    static void check_arr(int x, int y, int len){

        if (len == 1) {
            sb.append(arr[x][y]);
            return;
        }

        int color = arr[x][y];
        boolean check = true;

        loop:
        for(int i = x; i<x+len; i++){
            for(int j = y; j<y+len; j++){
                if (arr[i][j] != color) {
                    check = false;
                    break loop;
                }
            }
        }

        if (check) {
            sb.append(color);
            return;
        }else{
            sb.append("(");
            check_arr(x, y, len/2); 
            check_arr(x, y+len/2, len/2);
            check_arr(x+len/2, y, len/2);
            check_arr(x+len/2, y+len/2, len/2); 
            sb.append(")");
        }
    }
}
