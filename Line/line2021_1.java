package Line;

import java.util.*;

public class line2021_1 {
    public static void main(String[] args) {

        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", 
                            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", 
                            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                            "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = {"JAVA", "JAVASCRIPT" };
        int[] preference = { 7, 5};

        System.out.println(solution(table, languages, preference));

    }

    static String solution(String[] table, String[] languages, int[] preference) {

        HashMap<String, Integer> point = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            point.put(languages[i], preference[i]);
        }

        String answer = "";
        int max = 0;

        for (int i = 0; i < 5; i++) {
            int temp = 0;
            String[] detail = table[i].split(" ");
            for (int j = 1; j < 6; j++) {
                if (point.containsKey(detail[j])) {
                    temp += ((6-j)*point.get(detail[j]));
                }
            }

            if (temp > max) {
                max = temp;
                answer = detail[0];
            }else if(temp == max){                
                if (detail[0].compareTo(answer) < 0) {
                    answer = detail[0];
                }
            }
        }

        return answer;
    }
}