package BOJ;

/* 
    수 이어 쓰기 3
*/

import java.io.*;

public class BOJ2154 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2154().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder num = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            num.append(i);
        }

        int answer = num.toString().indexOf(String.valueOf(N))+1;

        System.out.println(answer);

    }

}
