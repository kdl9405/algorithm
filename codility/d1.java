package codility;

import java.util.*;

/**
 * d1
 */
public class d1 {

    public static void main(String[] args) {

        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";

        System.out.println(solution(S, C));

    }

    public static String solution(String S, String C) {

        String[] name = S.split("; ");

        C = "@" + C.toLowerCase() + ".com";

        HashMap<String, Integer> dupliCheck = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < name.length; i++) {
            String[] n = name[i].split(" ");
            if (n[n.length - 1].contains("-")) {
                n[n.length - 1] = n[n.length - 1].replaceAll("-", "");
            }
            if (n[n.length - 1].length() > 8) {
                n[n.length - 1] = n[n.length - 1].substring(0, 8);
            }

            String id = n[0].toLowerCase() + "." + n[n.length - 1].toLowerCase();
            dupliCheck.put(id, dupliCheck.getOrDefault(id, 0) + 1);
            if (dupliCheck.get(id) > 1) {
                id = id + dupliCheck.get(id);
            }

            sb.append(id).append(C);

            if (i != name.length - 1) {
                sb.append("; ");
            }
        }

        return sb.toString();
    }
}