package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ1564
 * 
 *
 */
class BOJ1564 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0, temp = 0, total = 0;

        String[] score = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(score[i]);
            if (temp > max)
                max = temp;

            total += temp;

        }

        double avg = 0;
        avg = 100.0 * total / max / n;
        System.out.printf("%.2f", avg);
      
    }
}