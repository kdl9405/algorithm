package boj;

/*
 * 크면서 작은 수
 */

import java.io.*;
import java.util.*;

public class BOJ2992 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] xArray = br.readLine().toCharArray();

        for (int i = xArray.length - 2; i >= 0; i--) {

            boolean isFind = false;
            int index = i;
            for (int j = xArray.length - 1; j > i; j--) {
                if (xArray[i] < xArray[j]) {

                    if (isFind) {
                        if (xArray[index] > xArray[j]) {
                            index = j;
                        }

                    } else {
                        index = j;
                        isFind = true;
                    }
                }
            }

            if (isFind) {
                char temp = xArray[i];
                xArray[i] = xArray[index];
                xArray[index] = temp;
                Arrays.sort(xArray, i + 1, xArray.length);

                System.out.println(new String(xArray));
                return;
            }
        }

        System.out.println(0);
    }
}
