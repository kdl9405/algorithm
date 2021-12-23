package BOJ;

/* 
    단어 수학

*/
import java.io.*;
import java.util.*;

public class BOJ1339_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> alphabet = new HashMap<>();

        int sum = 0;

        while (N-- > 0) {
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                alphabet.put(s.charAt(i),
                        alphabet.getOrDefault(s.charAt(i), 0) + (int) Math.pow(10, s.length() - i - 1));
            }
        }

        List<Character> list = new ArrayList<>(alphabet.keySet());
        Collections.sort(list, (a, b) -> {
            return alphabet.get(b) - alphabet.get(a);
        });

        int num = 9;
        for (char a : list) {
            sum += (num * alphabet.get(a));
            num--;

        }

        System.out.println(sum);

    }
}
