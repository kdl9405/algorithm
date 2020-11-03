package BJ;

import java.io.*;

public class BJ1003_copy {
    
    static Long[] arr;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int n;

        for(int i = 0; i<t; i++){
                       
            n = Integer.parseInt(br.readLine());
            arr = new Long[n+1];     
            
            if(n>0){
                
                sb.append(fibonaci(n-1)+" " +fibonaci(n)+"\n");
            }else{
                sb.append(1+" "+0+"\n");
            }         
           
           
        }

        System.out.println(sb);
        
    }

    static long fibonaci(int n){

        if(n == 0) {
            arr[n] = 0L;            
        }else if(n == 1){
            arr[n] = 1L; 
        }

        if(arr[n] == null){
            arr[n] = fibonaci(n-1) + fibonaci(n-2) ;
        }

        return arr[n];       
       
    }
}
