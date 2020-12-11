package nhn;

/**
 * 펀집거리
 */
public class edit_distance {

    public static void main(String[] args) {

        String s1 = "ABCD";
        String s2 = "ABD";

        System.out.println(solution(s1, s2));

    }

    static int solution(String s1, String s2) {

        int[][] arr = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            arr[i][0] = i;
        }
        for (int i = 1; i <= s2.length(); i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int min = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));

                if (s1.charAt(i-1) != s2.charAt(j-1)) {
                    min++;
                }
                arr[i][j] = min;
            }
        }

        return arr[s1.length()][s2.length()];
    }
}