package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    세 수 고르기

    1. S에 속하지 않은 자연수 x,y,z를 골라서 |N-xyz|의 최소값을 구하라..
    2. xyz 는 N보다 크거나 같거나 작다.
    3. 범위가 작으니. 그냥 완탐으로도 가능
*/

public class BOJ1503 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
      
        boolean[] num = new boolean[1002];

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            num[Integer.parseInt(st.nextToken())] = true;
        }

        int min = Integer.MAX_VALUE;

        for(int x = 1; x<=1001; x++){
            if (num[x]) {
                continue;
            }
            for(int y = x; y<=1001; y++){
                if (num[y]) {
                    continue;
                }
                for(int z = y; z<=1001; z++){
                    if (num[z]) {
                        continue;
                    }

                    int r =  Math.abs(N-(x*y*z));
                    min = Math.min(min, r);
                    if (N+1 < r) {
                        break;
                    }

                }
            }
        }

        System.out.println(min);
    }
}
