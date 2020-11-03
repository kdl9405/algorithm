
//조이스틱
public class pro23 {

    public static void main(String[] args) {

        System.out.println(solution("BBBBAAAABA"));

    }

    static int solution(String name) {
        int answer = 0;
        int Acount = 0;
        int A = 0;
        int cursor = 0;
        int length = name.length();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                Acount++;
                A = Math.max(A, Acount);
            } else {
                A = Math.max(A, Acount);
                Acount = 0;
            }
        }

        if (A == name.length()) {
            return 0;
        }

        if (A > 0) {
            String temp = "";

            for (int i = 0; i < A; i++) {
                temp += "A";
            }

            name = name.replace(temp, "*");

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '*') {
                    if (i == 0) {
                        cursor = name.length() - 1;
                    } else {

                        int l = (i - 1);
                        int r = (name.length() - 1 - i);
                        cursor = (2 * Math.min(l, r)) + Math.max(l, r);

                    }

                    break;
                }
            }
        } else {
            cursor = name.length() - 1;
        }

        cursor = Math.min(cursor, length - 1);

        for (int i = 0; i < name.length(); i++) {

            if (name.charAt(i) == '*') {
                continue;
            }

            int min = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

            answer = answer + min;

        }

        return answer + cursor;
    }

}
