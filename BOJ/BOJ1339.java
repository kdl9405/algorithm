package BOJ;

/* 
    단어 수학

*/
import java.io.*;
import java.util.*;

public class BOJ1339 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];

        while (N-- > 0) {
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                alphabet[s.charAt(i) - 'A'] += (int) Math.pow(10, s.length() - i - 1);
            }
        }

        Arrays.sort(alphabet);

        int sum = 0;
        int num = 9;
        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) {
                continue;
            }

            sum += (alphabet[i] * num);
            num--;
        }

        System.out.println(sum);

    }
}
