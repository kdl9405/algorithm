package BJ;

import java.io.*;
import java.util.*;

//시간초과
public class BJ1003 {
    
    static Long[] arr;
    static int firstC;
    static int secondC;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int n;

        for(int i = 0; i<t; i++){
            
            firstC = 0;
            secondC = 0;
            n = Integer.parseInt(br.readLine());
            arr = new Long[n+1];
            fibonaci(n);

            sb.append(firstC+" " +secondC+"\n");
            
        }

        System.out.println(sb);
        
    }

    static void fibonaci(int n){
        
        if(n == 0){
            firstC++;
        }else if(n==1){
            secondC++;
        }else if(arr[n] == null){
            
            fibonaci(n-1);
            fibonaci(n-2);
        }
    }
}
