package boj;

import java.io.*;

/*
 * 
 * 집합
 * 
 * 비트 마스킹
 * 
 */

public class BOJ11723 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int S = 0;

        while (t-- > 0) {

            String st = br.readLine();

            String[] str = st.split(" ");


            switch (str[0]) {
                case "add":

                    S |= (1 << Integer.parseInt(str[1]) - 1);
                    break;

                case "remove":

                    S &= ~(1 << Integer.parseInt(str[1]) - 1);
                    break;

                case "check":

                    if ((S & (1 << Integer.parseInt(str[1]) - 1)) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }

                    break;
                case "toggle":

                    S ^= (1 << Integer.parseInt(str[1]) - 1);

                    break;

                case "all":

                    S = (1 << 21) - 1;

                    break;
                case "empty":

                    S = 0;

                    break;
            }


        }


        System.out.println(sb.toString());
    }
}
