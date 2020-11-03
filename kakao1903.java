import java.util.*;

/**
 * kakao1903
 * 
 * 1. 밴 아이디하나씩 유저 아이디 전체 검색 2. 이미 선택된 유저 아이디 제외후 다음 밴 아이디로 유저 아이디 검색 3. 경우의 수 출력
 */
public class kakao1903 {

    public static HashSet<HashSet<String>> set = new HashSet<>();
    public static String[] user;
    public static String[] banned;

    public static void main(String[] args) {

        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr*d*", "*rodo", "******", "******" };

        solution(user_id, banned_id);

        System.out.println(set.size());

    }

    public static int solution(String[] user_id, String[] banned_id) {

        user = user_id;
        banned = banned_id;

        for (int i = 0; i < banned.length; i++) {
            banned[i] = banned[i].replace("*", "[\\w\\d]");
        }

        HashSet<String> list = new HashSet<>();
        bann(list, 0);

        return set.size();
    }

    public static void bann(HashSet<String> list, int idx) {

        if (idx == banned.length) {

            System.out.println(list);
            HashSet<String> temp = new HashSet<>();
            temp.addAll(list);
            set.add(temp);
            return;
        }

        for (int i = 0; i < user.length; i++) {

            if (!list.contains(user[i])) {

                if (user[i].matches(banned[idx])) {

                    list.add(user[i]);
                    bann(list, idx + 1);
                    list.remove(user[i]);

                }

            }

        }

        return;
    }

}