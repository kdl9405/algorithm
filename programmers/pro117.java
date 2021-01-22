package programmers;

import java.util.Arrays;

// 다트게임

public class pro117 {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        System.out.println(solution(dartResult));
    }

    static int solution(String dartResult) {
        int answer = 0;

        String[] str = new String[3];
        Arrays.fill(str, "");
        str[0] += dartResult.charAt(0);
        int j = 0;
        for (int i = 1; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i)) && dartResult.charAt(i - 1) != '1') {
                j++;
            }
            str[j] += dartResult.charAt(i);
        }

        int[] point = new int[3];

        for (int i = 0; i < 3; i++) {
            point[i] = Integer.parseInt(str[i].replaceAll("[^0-9]", ""));

            switch (str[i].replaceAll("[^A-Z]", "")) {
                case "D":
                    point[i] = (int) Math.pow(point[i], 2);
                    break;
                case "T":
                    point[i] = (int) Math.pow(point[i], 3);
                    break;
                default:
                    break;
            }

            if (str[i].charAt(str[i].length() - 1) == '*') {
                point[i] *= 2;
                if (i > 0) {
                    point[i - 1] *= 2;
                }
            } else if (str[i].charAt(str[i].length() - 1) == '#') {
                point[i] *= -1;
            }
        }
        for (int p : point) {
            answer += p;
        }

        return answer;
    }
}
