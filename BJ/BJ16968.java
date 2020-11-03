import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16968 {

    static int result;
    static int x = 26, y = 10;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        result = 1;

        cal(input, 0);

        System.out.println(result);

    }

    public static int cal(String str, int i) {

        if (i == str.length()) {
            return result;
        }

        switch (str.charAt(i)) {
            case 'c':

                if (i > 0 && str.charAt(i - 1) == str.charAt(i)) {

                    result = result * (x-1);

                    return cal(str, i + 1);
                } else {
                    result = result * x;
                    return cal(str, i + 1);

                }

            case 'd':
                if (i > 0 && str.charAt(i - 1) == str.charAt(i)) {
                    
                    result = result * (y-1);

                    return cal(str, i + 1);
                } else {
                    result = result * y;
                    return cal(str, i + 1);

                }
        }

        return result;
    }
}