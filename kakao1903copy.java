import java.util.*;

/**
 * kakao1903
 * 
 * 1. 밴 아이디하나씩 유저 아이디 전체 검색 2. 이미 선택된 유저 아이디 제외후 다음 밴 아이디로 유저 아이디 검색 3. 경우의 수 출력
 */
public class kakao1903copy {

    public static void main(String[] args) {

        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
        String[][] matched_id = new String[banned_id.length][user_id.length];
        ArrayList<String> list_id = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", "[\\w\\d]");

            int n = 0;

            for (int j = 0; j < user_id.length; j++) {

                if (user_id[j].matches(banned_id[i])) {

                    matched_id[i][n] = user_id[j];

                    n++;
                }

            }

        }

        

    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        return answer;
    }

}