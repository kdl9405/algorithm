package Line;

import java.util.*;

public class line2021_6 {

    public static void main(String[] args) {

        String program = "line";
        String[] flag_rules = { "-s STRINGS", "-n NUMBERS", "-e NULL" };
        String[] commands = { "line -n 100 102 -s hi -e", "line -n id pwd -n 100" };

        boolean[] result = solution(program, flag_rules, commands);
        for (boolean r : result) {
            System.out.println(r);
        }
    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        flagSearch = new HashMap<>();
        for (int idx = 0; idx < flag_rules.length; idx++) {
            String[] rule = flag_rules[idx].split(" ");
            flagSearch.put(rule[0], rule[1]);
        }

        for (int idx = 0; idx < commands.length; idx++) {
            String[] command = commands[idx].split(" ");
            if (commandCheck(program, command)) {
                answer[idx] = true;
            }
        }
        return answer;
    }

    static HashMap<String, String> flagSearch;
    static HashSet<String> usedFlag;

    static boolean commandCheck(String program, String[] command) {

        usedFlag = new HashSet<>();

        if (!command[0].equals(program)) {
            return false;
        }

        for (int idx = 1; idx < command.length; idx++) {

            String flag = command[idx];

            if (!flagSearch.containsKey(flag)) {
                return false;
            }
            if (usedFlag.contains(flag)) {
                return false;
            }
            usedFlag.add(flag);

            String argument_type = flagSearch.get(command[idx]);
            switch (argument_type) {
            case "NULL":
                break;

            case "STRING":
                idx++;
                if (command[idx].replaceAll("[A-Za-z]", "").length() > 0) {
                    return false;
                }
                break;

            case "NUMBER":
                idx++;
                if (command[idx].replaceAll("[0-9]", "").length() > 0) {
                    return false;
                }
                break;

            case "STRINGS":

                while (++idx < command.length && command[idx].charAt(0) != '-') {
                    if (command[idx].replaceAll("[A-Za-z]", "").length() > 0) {
                        return false;
                    }
                }
                idx--;
                break;

            case "NUMBERS":

                while (++idx < command.length && command[idx].charAt(0) != '-') {
                    if (command[idx].replaceAll("[0-9]", "").length() > 0) {
                        return false;
                    }
                }
                idx--;
                break;

            }
        }

        return true;
    }
}