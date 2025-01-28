package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ10996 {

    /**
     * InnerBOJ10996
     * 
     * @throws IOException
     * @throws NumberFormatException
     */

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String star = " *";

        StringBuilder line1 = new StringBuilder("*");
        StringBuilder line2 = new StringBuilder("");

        for (int j = N; j > 0; j--) {

            if (j % 2 == 1 & j != 1)
                line1.append(star);
            else if (j % 2 == 0)
                line2.append(star);
        }

        for (int i = 0; i < N; i++) {

            System.out.println(line1);
            System.out.println(line2);

        }

    }

}
