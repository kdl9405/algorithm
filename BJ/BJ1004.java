package BJ;

import java.io.*;
import java.util.*;

public class BJ1004 {
    
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            int c = sc.nextInt();
            int answer = 0;
            
            for(int j = 0; j<c; j++){
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int cr = sc.nextInt();
                cr*=cr;
                
                int a = (Math.abs(cx-x1)*Math.abs(cx-x1))+(Math.abs(cy-y1)*Math.abs(cy-y1));
                int b = (Math.abs(cx-x2)*Math.abs(cx-x2))+(Math.abs(cy-y2)*Math.abs(cy-y2));

                System.out.println("!!!!!!!!"+a +" "+b +" "+cr);
                
                if(a<=cr && b>cr){
                    answer++;
                }else if(a>cr && b<=cr){
                    answer++;
                }
            }
            
            sb.append(answer+"\n");
            
        }
        
        System.out.println(sb);        
    }
}
