import java.util.Arrays;

/**
 * [3차] 파일명 정렬
 * 
 */
public class pro76 {

    public static void main(String[] args) {

        String[] files = { "img12", "img10", "img02", "img1", "IMG01", "img2" };

        String[] result = solution(files);
        for (String s : result) {
            System.out.println(s);
        }

    }

    static String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, (f1, f2) -> {

            String[] x = divide(f1);
            String[] y = divide(f2);

            if (x[0].equals(y[0])) {
                return Integer.parseInt(x[1]) - Integer.parseInt(y[1]);
            }

            return x[0].compareTo(y[0]);
        });

        answer = files.clone();

        return answer;
    }

    static String[] divide(String s) {

        String[] answer = new String[2];

        int start = 0;
        int fin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                start = i;
                break;
            }
        }
        if (start != s.length() - 1) {
            for (int j = start + 1; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j))) {
                    fin = j;
                    break;
                }
            }
            if (fin == 0) {
                fin = s.length();
            }
        } else {
            fin = start + 1;
        }

        answer[0] = s.substring(0, 0 + start).toUpperCase();
        answer[1] = s.substring(start, fin);

        return answer;
    }
}