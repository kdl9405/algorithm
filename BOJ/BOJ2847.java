package BOJ;

/* 
    게임을 만든 동준이
*/

import java.io.*;

public class BOJ2847 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] point = new int[N];
        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int decrement = 0;

        for (int i = N - 2; i >= 0; i--) {
            if (point[i] >= point[i + 1]) {
                decrement += (point[i] - (point[i + 1] - 1));
                point[i] = point[i + 1] - 1;
            }
        }

        System.out.println(decrement);
    }
}
