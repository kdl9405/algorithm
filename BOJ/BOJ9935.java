package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    문자열 폭발
*/
public class BOJ9935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String x = br.readLine();

        char[] arr = new char[s.length()];

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[idx] = s.charAt(i);

            if (idx >= x.length() - 1) {
                boolean check = true;
                for (int j = 0; j < x.length(); j++) {
                    if (x.charAt(j) != arr[idx - x.length() + 1 + j]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    idx -= x.length();
                }
            }
            idx++;
        }

        if (idx == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(String.valueOf(arr,0,idx));
        }
    }

}
