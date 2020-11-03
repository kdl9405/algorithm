
// 큰 수 만들기
public class pro22_copy {

    public static void main(String[] args) {

        System.out.println(solution("113300", 2));
    }

    static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);

        int cnt = 0;
        int i = 0;
        while (cnt < k) {
            if (i == answer.length() - 1) {
                answer.deleteCharAt(i);
                cnt++;
                i = 0;
                continue;
            }
            if (answer.charAt(i) == '9') {
                i++;
                continue;
            }
            if (answer.charAt(i) < answer.charAt(i+1)) {
                answer.deleteCharAt(i);
                cnt++;
                i = 0;
            } else {
                i++;
            }
        }
        
        return answer.toString();
    }
}