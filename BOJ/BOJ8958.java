import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ8958
 * 
 *
 */
class BOJ8958 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] totalscore;
        totalscore = new int[t];

        for (int n = 0; n < t; n++) {

            String[] result = br.readLine().split("");

            int score = 0, total = 0;

            for (int i = 0; i < result.length; i++) {

                if (result[i].equals("O")) {
                    score += 1;

                    total += score;

                } else if (result[i].equals("X")) {
                    score = 0;
                }

            }
            
            totalscore[n] = total;
        }

        for (int j = 0; j<t; j++)
            System.out.println(totalscore[j]);
    }
}