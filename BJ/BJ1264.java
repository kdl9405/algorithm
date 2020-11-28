package BJ;

import java.io.*;

public class BJ1264 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String x = "AEIOUaeiou";
        
        while(true){
            String s = br.readLine();
            if(s.equals("#")){
                break;
            }
            
            int count = 0;
            for(int i = 0; i<s.length(); i++){
                if(x.contains(s.charAt(i)+"")){
                    count++;
                }
            }
            sb.append(count +"\n");
        }
        
        System.out.println(sb);
    }
}
