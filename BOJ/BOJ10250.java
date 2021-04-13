import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int h,w,n = 0;

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int rH = n % h;
            int rW = n / h + 1;

            if (n % h == 0) {
                rH = h;
                rW--;
            }

            if (rW < 10) {
                System.out.println(rH + "0" + rW);

            } else {
                System.out.println(rH + "" + rW);
            }
        }

    }
}