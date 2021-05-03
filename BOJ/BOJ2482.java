package BOJ;

import java.io.*;

/* 
    색상환

    
*/
public class BOJ2482 {

    static long[][] combintaion;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K * 2 > N) {
            System.out.println(0);
            return;
        }

        combintaion = new long[N + 1][N + 1];

        for(int i = 0; i<=N; i++){
            combintaion[i][1] = i;
            combintaion[i][0] = 1;
        }

        for(int i = 2; i<=N; i++){
            for(int j = 2; j<=K; j++){
                combintaion[i][j] = (combintaion[i-2][j-1] + combintaion[i-1][j]) % 1000000003;
            }
        }

        System.out.println((combintaion[N-3][K-1] + combintaion[N-1][K])%1000000003);
    }

}
