package Line;

import java.util.*;

public class line2021_7 {

    public static void main(String[] args) {

        String program = "line";
        String[] flag_rules = { "-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num" };
        String[] commands = { "line -n 100 -s hi -e", "line -n 100 -e -num 150" };

        boolean[] result = solution(program, flag_rules, commands);
        for (boolean r : result) {
            System.out.println(r);
        }

    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        flagSearch = new HashMap<>(); 
        alias = new HashMap<>();
        for (int idx = 0; idx < flag_rules.length; idx++) {
            String[] rule = flag_rules[idx].split(" ");
            if (rule[1].equals("ALIAS")) {  // alias에 대한 정의면 alias에 입력
                alias.put(rule[0], rule[2]);
            } else {  //  flas-argument에 대한 정의면 flagSearch에 입력
                flagSearch.put(rule[0], rule[1]);
            }
        }

        for (int idx = 0; idx < commands.length; idx++) {  // commands를 순회하면서 각 command에 대한 결과값을 answer에 담음.
            String[] command = commands[idx].split(" ");
            if (commandCheck(program, command)) {
                answer[idx] = true;
            }
        }
        return answer;
    }

    static HashMap<String, String> flagSearch; // flag - argument
    static HashMap<String, String> alias;  // name - alias
    static HashSet<String> usedFlag; // flag 사용여부

    static boolean commandCheck(String program, String[] command) {

        usedFlag = new HashSet<>(); // 각 command마다 초기화

        if (!command[0].equals(program)) {  // command와 program의 일치여부
            return false;
        }

        for (int idx = 1; idx < command.length; idx++) { // command안의 flag 순회

            String flag = command[idx];
           
            if (alias.containsKey(flag)) {  // flag가 alias라면 flag를 원래 이름으로 변경
                flag = alias.get(flag);
            }

            if (usedFlag.contains(flag)) {  // flag가 사용된 flag면 false
                return false;
            } 
            usedFlag.add(flag);

            if (!flagSearch.containsKey(flag)) {  // flag가 rule에 존재하지 않으면 false반환
                return false;
            }
          
            idx = argumentCheck(flagSearch.get(flag), idx, command); // flag 뒤에오는 argument에 대해 체크/ 틀린경우 -1
            if (idx < 0) {
                return false;
            }

        }

        return true;
    }

    static int argumentCheck(String argument_type, int idx, String[] command) { // flag의 argument 체크

        switch (argument_type) {

        case "NULL":
            break;

        case "STRING":
            idx++;
            if (command[idx].replaceAll("[A-Za-z]", "").length() > 0) {
                return -1;
            }
            break;

        case "NUMBER":
            idx++;
            if (command[idx].replaceAll("[0-9]", "").length() > 0) {
                return -1;
            }
            break;

        case "STRINGS":

            while (++idx < command.length && command[idx].charAt(0) != '-') {
                if (command[idx].replaceAll("[A-Za-z]", "").length() > 0) {
                    return -1;
                }
            }
            idx--;
            break;

        case "NUMBERS":

            while (++idx < command.length && command[idx].charAt(0) != '-') {
                if (command[idx].replaceAll("[0-9]", "").length() > 0) {
                    return -1;
                }
            }
            idx--;
            break;
        }

        return idx;
    }
 
}