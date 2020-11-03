/**
 * 짝지어 제거하기
 * // 시간초과
 */
public class pro65_copy {

    public static void main(String[] args) {
        String s = "baabaa";

        System.out.println(solution(s));
    }

    static int solution(String s) {
        int answer = 0;

       String[] arr = new String[26];
       for(int i = 0; i<26; i++){
           arr[i] = Character.toString(i+'a');
           arr[i] += arr[i];
       }

       while (true) {

            if (s.length() == 0) {
                answer = 1;
                break;
            }

            boolean check = false;           
            for(String ch : arr){
                if (s.contains(ch)) {
                    s = s.replaceAll(ch, "");
                    check = true;
                }
            }

            if (!check) {
                answer = 0;
                break;
            }
       }

        return answer;
    }
}