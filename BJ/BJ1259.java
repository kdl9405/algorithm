package BJ;

import java.util.*;
import java.io.*;

public class BJ1259 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String num = br.readLine();
            if(num.equals("0")){
                break;
            }
            
            int last = num.length()-1;
            boolean check = true;
            for(int i = 0; i<(last+1)/2; i++){
                if(num.charAt(i) != num.charAt(last-i)){
                    check = false;
                    break;
                }
            }
            
            if(check){
                sb.append("yes"+"\n");
            }else{
                sb.append("no"+"\n");
            }
        }
        
        System.out.println(sb);
    }
}
