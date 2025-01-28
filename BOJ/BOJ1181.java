package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// 시간초과
public class BOJ1181 {

    public static void main(final String[] args) throws NumberFormatException, IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        final int n = Integer.parseInt(br.readLine());

        final String[] st_count = new String[50];

        String word;
        for (int i = 0; i < n; i++) {

            word = br.readLine();

            if (st_count[word.length() - 1] == null) {
                st_count[word.length() - 1] = " ";
            }

            st_count[word.length() - 1] = st_count[word.length() - 1] + word + " ";
        }

        String[] str;
        HashSet<String> strset;
        for (int i = 0; i < 50; i++) {

            if (st_count[i] != null) {

                st_count[i] = st_count[i].trim();

                str = st_count[i].split(" ");

                strset = new HashSet<>();
                for (final String item : str) {
                    strset.add(item);
                }

                final OBOJect[] result = strset.toArray();
                Arrays.sort(result);

                for (int j = 0; j < result.length; j++) {
                    sb.append(result[j]).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}
