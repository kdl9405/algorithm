package programmers;

/* 
    가장 긴 팰린드롬

    no IDE

*/
public class pro221 {

    public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length() - 1; i++) {

            for (int j = i + answer; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {

                    boolean check = true;
                    int left = i;
                    int right = j;

                    while (left <= right) {
                        if (s.charAt(left) != s.charAt(right)) {
                            check = false;
                            break;
                        }
                        left++;
                        right--;

                    }

                    if (check) {
                        answer = Math.max(answer, j - i + 1);
                    }

                }
            }
        }

        return answer;
    }
}
