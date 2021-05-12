package BOJ;

import java.io.*;

/* 
    IOIOI 
*/
public class BOJ5525 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;

        for(int i = 0; i<M-(2*N+1); i++){

            if (S.charAt(i) == 'I') {
                int count = 0;
                int j = i+1;

                for(; j<M-1; j+=2){
                    if (S.charAt(j) == 'O' && S.charAt(j+1) == 'I'){
                        count++;
                    }else break;
                }
                if (count >= N) {
                    answer += (count-N+1);                   
                }
                i = j-1;

            }
        }

        System.out.println(answer);

    }
}
