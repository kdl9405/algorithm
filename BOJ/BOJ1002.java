package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1002 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String str[] = br.readLine().split(" ");

            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int r1 = Integer.parseInt(str[2]);
            int x2 = Integer.parseInt(str[3]);
            int y2 = Integer.parseInt(str[4]);
            int r2 = Integer.parseInt(str[5]);

            double DPow = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2); 

            if (x1==x2 && y1==y2 && r1==r2) {
                System.out.println(-1);
            } else if (DPow < Math.pow(r1-r2, 2)){
                System.out.println(0);
            } else if (DPow == Math.pow(r1-r2, 2)){
                System.out.println(1);
            } else if (DPow == Math.pow(r1+r2, 2)){
                System.out.println(1);
            } else if (DPow > Math.pow(r1+r2, 2)){
                System.out.println(0);
            } else {
                System.out.println(2);
            }

        }
    }
}