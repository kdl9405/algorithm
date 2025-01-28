package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2675 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] R = new int[T];
        String[] S = new String[T];

        for (int i = 0; i < T; i++) {
            R[i] = br.read() - 48;
            S[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {

            for (int x = 1; x < S[i].length(); x++) {
                for (int y = 0; y < R[i]; y++) {
                    System.out.print(S[i].charAt(x));
                }
            }
            System.out.println();
        }
    }
}
