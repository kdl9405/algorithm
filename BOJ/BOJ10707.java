package BOJ;

/* 
    수도요금 
*/

import java.io.*;

public class BOJ10707 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int X = A*P;

        int Y = B;
        if (P > C) {
            Y += D * (P - C);
        }

        System.out.println((X < Y) ? X : Y);

    }

}
