package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
    단어 맞추기
*/
public class BOJ9081 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(next(br.readLine()) + "\n");
        }

        System.out.println(sb.toString());
    }

    static String next(String s) {

        if (s.length() == 1) {
            return s;
        }

        int min = 0;
        int index = 0;

        loop:
        for(index = s.length()-2; index>=0; index--){
            for(min = s.length()-1; min>index; min--){
                if (s.charAt(index) < s.charAt(min)) {
                    break loop;
                }
            }
        }

      //  System.out.println("index  " + index+"  min = " + min);
        if (index == -1) {
            return s;
        }

        char[] arr = s.toCharArray();
        char temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;

        Arrays.sort(arr, index + 1, arr.length);
        StringBuilder sb = new StringBuilder();
        for (char a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}
