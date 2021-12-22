package BOJ;

/* 
    동물원
*/

import java.io.*;

public class BOJ1309 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] zoo = new int[N + 1][3];
        zoo[1][0] = 1;
        zoo[1][1] = 1;
        zoo[1][2] = 1;


        for (int i = 2; i <= N; i++) {
            zoo[i][0] = (zoo[i - 1][0] + zoo[i - 1][1] + zoo[i - 1][2]) % 9901;
            zoo[i][1] = (zoo[i - 1][0] + zoo[i - 1][2]) % 9901;
            zoo[i][2] = (zoo[i - 1][0] + zoo[i - 1][1]) % 9901;
        }

        System.out.println((zoo[N][0] + zoo[N][1] + zoo[N][2]) % 9901);

    }
}
