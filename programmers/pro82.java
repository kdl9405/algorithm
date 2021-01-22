package programmers;

import java.util.HashMap;

/**
 * pro82
 * 브라이언의 고민
 */
public class pro82 {
    public static void main(String[] args) {

        String sentence = "SpIpGpOpNpGJqOqA";

        System.out.println(solution(sentence));
    }

    static String solution(String sentence) {
        String answer = "invalid";

        if (sentence.contains(" ")) {
            return answer;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Character.isLowerCase(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        loop:
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (i == sentence.length()-1) {
                sb.append(c);
                break;
            }
            System.out.println("index : " +i+"    char : "+c);

            if (Character.isUpperCase(c)) {

                for(int j = i+1; j<sentence.length(); j++){
                    if(Character.isLowerCase(sentence.charAt(j))){
                        i = j-1;
                        break;
                    }else {
                        sb.append(sentence.charAt(j));
                    }

                    if(j == sentence.length()-1){
                        break loop;
                    }
                }

                c = sentence.charAt(i + 1);

                System.out.println("!!!!!!!!!!!!index : " +i+"    char : "+c);


                if (map.get(c) == 2) {
                    sb.append(sentence.charAt(i)+" ");
                    continue;
                }
                
                int count = 0;

                for (int j = i + 1; j < sentence.length(); j += 2) {
                    if (sentence.charAt(j) == c) {
                        count++;
                    }
                    if (count == map.get(c)) {
                        String temp = sentence.substring(i, j + 2);
                        temp = temp.replaceAll(Character.toString(c), "");
                        sb.append(temp);
                        i = j + 1;
                        break;
                    }
                }

            } else {
                for (int j = i + 1; j < sentence.length(); j++) {
                    if (sentence.charAt(j) == c) {

                        if (map.get(c) != 2) {
                            return answer;
                        }

                        String temp = sentence.substring(i, j);
                        temp = temp.replaceAll(Character.toString(c), "");
                        if (temp.length() > 1 && Character.isLowerCase(temp.charAt(1))) {
                            c = temp.charAt(1);
                            int count = 0;
                            for (int x = 1; x < temp.length(); x += 2) {
                                if (temp.charAt(x) == c) {
                                    count++;
                                }
                                if (count == map.get(c)) {
                                    temp = temp.replaceAll(Character.toString(c), "");
                                }
                            }
                        }

                        i = j;
                        sb.append(temp);

                        break;
                    }
                }

            }
            sb.append(" ");
        }

        String change = sb.toString();

        System.out.println(change);

        for (int j = 0; j < change.length(); j++) {
            if (Character.isLowerCase(change.charAt(j))) {
                return answer;
            }
        }
        answer = change.trim();

        return answer;
    }
}