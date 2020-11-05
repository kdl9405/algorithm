/**
 * pro107
 */
public class pro107 {

    public static void main(String[] args) {

        int[] result = solution("110010101001");
        System.out.println(result[0] + "  " + result[1]);

    }

    static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            answer[0]++;

            if (s.contains("0")) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') {
                        answer[1]++;
                    }
                }
                s = s.replaceAll("0", "");
            }
            s = Integer.toBinaryString(s.length());

        }

        return answer;
    }
}