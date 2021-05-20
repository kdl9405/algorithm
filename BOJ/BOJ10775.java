package BOJ;

import java.io.*;
import java.util.*;

/* 
    공항 
*/
public class BOJ10775 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] gate = new int[G + 1];
        root = new int[G + 1];

        int count = 0;

        while (P-- > 0) {
            int x = Integer.parseInt(br.readLine());

            int to = findRoot(x);

            if (to > 0 && gate[to] == 0) {
                gate[to]++;
                root[to]--;
                count++;
            } else {
                break;
            }
        }
     
        System.out.println(count);
    }

    static int[] root;

    static int findRoot(int n) {
        if (root[n] == 0) {
            return root[n] = n;
        }
        if (root[n] == n) {
            return n;
        }

        return root[n] = findRoot(root[n]);
    }

}
