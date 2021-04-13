package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                index = i;
                break;
            }
        }
        
        if (index == 0) {
            String[] str = s.split("[+-]");
            int sum = 0;
            for (String st : str) {
                sum += Integer.parseInt(st);
            }
            System.out.println(sum);


        } else {

            String fir = s.substring(0, index);
            String sec = s.substring(index + 1, s.length());

            int sum = 0;

            String[] str = fir.split("[+-]");

            for (String st : str) {
                sum += Integer.parseInt(st);
            }

            String[] str2 = sec.split("[+-]");
            for (String st : str2) {
                sum -= Integer.parseInt(st);
            }

            System.out.println(sum);
        }

    }
}
