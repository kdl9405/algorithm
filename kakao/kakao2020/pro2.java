package kakao.kakao2020;

//괄호변환
public class pro2 {

    public static void main(String[] args) {

        System.out.println(solution("()))((()"));
    }

    static String solution(String p) {
        String answer = check(p);
        return answer;
    }

    static String check(String p) {
        String u = "", answer = "", v = "";
        boolean isRight = true;

        int check = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                check++;
            } else
                check--;

            u += p.charAt(i);

            if (check < 0) {
                isRight = false;
            } else if (check == 0) {
                String nv = p.substring(i + 1, p.length());
                if (nv.length() != 0) {
                    v = check(nv);
                }
                if (isRight == true) {
                    answer += u;
                } else
                    v = make(u, v);

                break;
            }
        }
        return answer+v;
    }

    static String make(String u, String v){
        String answer = "("+v+")";

        for(int i = 1; i<u.length()-1; i++){
            if (u.charAt(i) == '(') {
                answer+=")";
            }else answer+="(";
        }

        return answer;
    }

}