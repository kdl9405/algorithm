package kakao.kakao2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pro1 {
    public static void main(String[] args) {

        String new_id = "...!@BaT#*..y.abcdefghijkl_-m.";

        System.out.println(solution(new_id));

    }

    static String solution(String new_id) {

        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^0-9a-z._-]", "");

        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        StringBuilder sb = new StringBuilder(new_id);

        if (sb.charAt(0) == '.') {
            sb.setCharAt(0, ' ');
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.setCharAt(sb.length() - 1, ' ');
        }

        new_id = sb.toString().trim();

        if (new_id.length() == 0) {
            new_id = "a";
        } else if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.charAt(new_id.length() - 1) == '.') {
            sb = new StringBuilder(new_id);
            sb.setCharAt(sb.length() - 1, ' ');
            new_id = sb.toString().trim();
        }

        if (new_id.length() < 3) {
            char c = new_id.charAt(new_id.length() - 1);

            sb = new StringBuilder(new_id);

            while (sb.length() < 3) {
                sb.append(c);
            }
            new_id = sb.toString();
        }

        return new_id;
    }
}
