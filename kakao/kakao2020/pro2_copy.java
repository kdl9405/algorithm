package kakao.kakao2020;

//괄호변환
public class pro2_copy {

    public static void main(String[] args) {

        System.out.println(solution("(()())()"));
    }

    static String solution(String p) {

        String[] str = cutS(p);

        StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < str.length; i++) {
        // sb.append(change(str[i]));
        // }

        return sb.toString();
    }

    static String[] cutS(String p) {

        String[] str = new String[p.length() / 2 + 1];

        int open = 0;
        int close = 0;

        StringBuilder sb = new StringBuilder();

        int j = 0;

        for (int i = 0; i < p.length(); i++) {

            if (p.charAt(i) == '(') {
                open++;
            }

            if (p.charAt(i) == ')') {
                close++;
            }

            sb.append(p.charAt(i));

            if (open != 0 && open == close) {

                str[j] = sb.toString();
                j++;
                open = 0;
                close = 0;

                sb = new StringBuilder();
            }
        }

        for (int i = 0; i < str.length; i++) {

            System.out.println(str[i]);


            if (str[i] == null) {
                break;
            }

            int count = 0;
            for (int x = 0; x < str[i].length(); x++) {
                if (str[i].charAt(x) == '(') {
                    count++;
                } else
                    count--;

                if (count < 0) {
                    StringBuilder sb2 = new StringBuilder();

                    for (String st : cutS(str[i])) {
                        sb2.append(change(st));
                    }

                    str[i] = sb2.toString();
                }
            }

        }

        

        return str;

    }

    static String change(String str) {

        int count = 0;
        for (int x = 0; x < str.length(); x++) {
            if (str.charAt(x) == '(') {
                count++;
            } else
                count--;

            if (count < 0) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < str.length(); i++) {

                    if (i == 0) {
                        sb.append("(");
                    } else if (i == str.length() - 1) {
                        sb.append(")");
                    } else {
                        if (str.charAt(i) == '(') {
                            sb.append(")");
                        } else {
                            sb.append("(");
                        }
                    }
                }

                return sb.toString();

            }

        }

        return str;

    }
}
