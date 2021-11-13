package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    치킨치킨치킨
*/
public class BOJ16439 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        like = new int[n][m];

        for(int i = 0; i<n; i++){
            like[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;

        for(int a = 0; a<m-2; a++){
            for(int b = a+1; b<m-1; b++){
                for(int c = b+1; c<m; c++){

                    int temp = 0;
                    for(int i = 0; i<n; i++){
                        temp += Math.max(like[i][a], Math.max(like[i][b], like[i][c]));
                    }

                    answer = Math.max(answer, temp);
                }
            }
        }

        System.out.println(answer);
    }

    static int[][] like;
}
