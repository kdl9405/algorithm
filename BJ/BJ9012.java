import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9012 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int i = 0;
        while (i < n) {

            String s = br.readLine();
            int count = 0;
            for (int x = 0; x < s.length(); x++) {

                if (count < 0) {
                    break;
                }

                if (s.charAt(x) == '(') {
                    count++;
                } else if (s.charAt(x) == ')') {
                    count--;
                }
            }

            if (count == 0) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }

            i++;
        }

        System.out.println(sb);

    }
}
