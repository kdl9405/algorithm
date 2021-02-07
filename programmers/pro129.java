package programmers;

/* 
    신규 아이디 추천

*/

public class pro129 {

    public static void main(String[] args) {

        String new_id = "abcdefghijklmn.p";

        System.out.println(solution(new_id));

    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9._-]", "");

        if (answer.length() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(answer.charAt(0));
            for (int i = 1; i < answer.length(); i++) {
                if ((sb.charAt(sb.length() - 1) == '.') && answer.charAt(i) == '.') {
                    continue;
                }
                sb.append(answer.charAt(i));
            }
            answer = sb.toString();
        }

        if (answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        if (answer.length()>1 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.length() == 0) {
            answer = "a";
        }
        if (answer.length() > 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        if (answer.length() < 3) {
            char c = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer = answer + c;
            }
        }
        return answer;
    }
}
