package BJ;

import java.io.IOException;
import java.util.*;

public class BJ1371 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
       
        int[] alphabet = new int[26];

        while (sc.hasNextLine()) {
            
            String s = sc.nextLine();
            for(int i = 0; i<s.length(); i++){
                int n = s.charAt(i) - 'a';
                
                if(n>=0 && n<27){
                    alphabet[n]++;
                }
            }
        }
       
        int max = 0;
        String answer = "";
        
        for(int i = 0; i<26; i++){
            if(alphabet[i] == max){
                answer += (char)(i+'a');
            }else if(alphabet[i] > max){
                max = alphabet[i];
                answer = ""+(char)(i+'a');
            }
        }
        
        System.out.println(answer);
        
    }
}
