package kakao.kakao2021;

import java.util.Arrays;

public class pro3 {

    public static void main(String[] args) {

        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100", "- and - and - and - 150" };

        int[] answer = solution(info, query);

        for (int a : answer) {
            System.out.println(a);
        }
    }

    static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        int a = 0;

        for (String q : query) {

            q = q.replaceAll("and ", "");

            String[] qstr = q.split(" ");

            int score = Integer.parseInt(qstr[4]);

            String[] infocopy = info.clone();

            Arrays.sort(infocopy, (i1, i2) -> {
                return Integer.parseInt(i2.split(" ")[4]) - Integer.parseInt(i1.split(" ")[4]);
            });

            int index = 0;
            for (int i = 0; i < infocopy.length; i++) {
                if (Integer.parseInt(infocopy[i].split(" ")[4]) < score) {
                    index = i;
                    break;
                }                
            }
           
            if (qstr[0].equals("-") && qstr[1].equals("-") && qstr[2].equals("-") && qstr[3].equals("-")) {
                answer[a] = index;
                a++;
            } else {
                int count = 0;
                for (int j = 0; j < index; j++) {
                    String[] istr = infocopy[j].split(" ");
                    if (!istr[0].equals(qstr[0]) && !qstr[0].equals("-")) {
                        infocopy[j] = "X";
                        continue;
                    } else if (!istr[1].equals(qstr[1]) && !qstr[1].equals("-")) {
                        infocopy[j] = "X";
                        continue;
                    } else if (!istr[2].equals(qstr[2]) && !qstr[2].equals("-")) {
                        infocopy[j] = "X";
                        continue;
                    } else if (!istr[3].equals(qstr[3]) && !qstr[3].equals("-")) {
                        infocopy[j] = "X";
                        continue;
                    } else {
                        count++;
                    }
                }

                answer[a] = count;
                a++;
            }

        }

        return answer;
    }
}
