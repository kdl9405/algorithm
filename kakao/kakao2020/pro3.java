package kakao.kakao2020;

import java.util.HashMap;

// 오픈채팅방
public class pro3 {

    public static void main(String[] args) {

        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo"};

        String[] answer = solution(record);

        for (String ans : answer) {
            System.out.println(ans);
        }
    }

    static String[] solution(String[] record) {

        HashMap<String, String> hash = new HashMap<>();
        int count = 0;

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");

            if (!str[0].equals("Change") ) {
                count++;
            }

            if (str.length == 3) {
                hash.put(str[1], str[2]);
            }

        }

        String[] answer = new String[count];

        StringBuilder sb = new StringBuilder();

        int j = 0;

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");

            switch (str[0]) {
                case "Enter":
                    sb.append(hash.get(str[1])).append("님이 들어왔습니다.");
                    answer[j] = sb.toString();
                    sb = new StringBuilder();
                    j++;
                    break;

                case "Leave":
                    sb.append(hash.get(str[1])).append("님이 나갔습니다.");
                    answer[j] = sb.toString();
                    sb = new StringBuilder();
                    j++;
                    break;
                case "Change":
                    break;
            }
        }

        return answer;
    }
}
