package kakao.kakao2020;

// 문자열 압축
public class pro1 {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        System.out.println(solution("ababcdcdababcdcd"));

    }

    static int solution(String s) {

        if (s.length() <3) {
            return s.length();
        }

        for(int i = 1; i<s.length()/2 +1; i++){
            cutS(i, s);
        }

        return min;
    }

    static void cutS(int n, String s) {

        String[] str = {};

        if (s.length() % n != 0) {
            str = new String[(s.length() / n) + 1];
        } else {
            str = new String[s.length() / n];
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));
            count++;

            if (count == n) {
                str[j] = sb.toString();
                j++;
                count = 0;
                sb = new StringBuilder();
            } else if (i == s.length() - 1) {
                str[j] = sb.toString();
                sb = new StringBuilder();
                break;
            }
        }

        String temp = str[0];
        count = 1;

        for (int i = 1; i < str.length; i++) {

            if (i == str.length - 1) {
                if (temp.equals(str[i])) {
                    count++;
                    sb.append(count).append(temp);
                } else {
                    if (count > 1) {
                        sb.append(count).append(temp).append(str[i]);
                    } else {
                        sb.append(temp).append(str[i]);
                    }
                }
                break;
            }

            if (!temp.equals(str[i])) {
                if (count > 1) {
                    sb.append(count).append(temp);
                } else {
                    sb.append(temp);
                }

                count = 1;
                temp = str[i];

            } else if (temp.equals(str[i])) {
                count++;
            }
        }

        min = Math.min(min, sb.length());

    }
}
