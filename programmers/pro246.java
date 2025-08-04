package programmers;

/* 2022 KAKAO TECH INTERNSHIP
성격 유형 검사하기 */

import java.util.HashMap;
import java.util.Map;

public class pro246 {

    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> typePoint = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {

            char[] surveyType = survey[i].toCharArray();

            switch (choices[i]) {
                case 1:
                case 2:
                case 3:
                    typePoint.put(surveyType[0], typePoint.getOrDefault(surveyType[0], 0) + (4 - choices[i]));
                    break;
                case 4:
                    break;
                case 5:
                case 6:
                case 7:
                    typePoint.put(surveyType[1], typePoint.getOrDefault(surveyType[1], 0) + (choices[i] - 4));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((typePoint.getOrDefault('R', 0) - typePoint.getOrDefault('T', 0) >= 0) ? 'R' : 'T');
        sb.append((typePoint.getOrDefault('C', 0) - typePoint.getOrDefault('F', 0) >= 0) ? 'C' : 'F');
        sb.append((typePoint.getOrDefault('J', 0) - typePoint.getOrDefault('M', 0) >= 0) ? 'J' : 'M');
        sb.append((typePoint.getOrDefault('A', 0) - typePoint.getOrDefault('N', 0) >= 0) ? 'A' : 'N');

        return sb.toString();
    }
}
