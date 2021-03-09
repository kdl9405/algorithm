package BJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();

        int[] num_count = new int[10];

        for (int i = 0; i < n.length(); i++) {

            num_count[n.charAt(i) - '0'] += 1;

        }

        for (int i = 9; i >= 0; i--) {

            if (num_count[i] != 0) {

                while (num_count[i] != 0) {
                    sb.append(i);
                    num_count[i] -= 1;
                }

            }
        }
        System.out.println(sb);

    }
}