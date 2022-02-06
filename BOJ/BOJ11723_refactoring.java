package BOJ;

/* 
    집합 
*/

import java.io.*;
import java.util.*;

public class BOJ11723_refactoring {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        BitSet S = new BitSet(21);

        StringBuilder answer = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String oper = st.nextToken();

            switch (oper) {
                case "add":

                    S.set(Integer.parseInt(st.nextToken()));

                    break;
                case "remove":

                    S.clear(Integer.parseInt(st.nextToken()));

                    break;

                case "check":

                    answer.append((S.get(Integer.parseInt(st.nextToken()))) ? "1\n" : "0\n");

                    break;
                case "toggle":

                    int x = Integer.parseInt(st.nextToken());

                    if (S.get(x)) {
                        S.clear(x);
                    } else {
                        S.set(x);
                    }

                    break;

                case "all":

                    S.set(1, 21, true);

                    break;
                case "empty":

                    S.set(1, 21, false);

                    break;

                default:
                    break;
            }
        }



        System.out.println(answer.toString().trim());
    }

}
