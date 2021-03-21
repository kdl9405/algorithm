package Line;

import java.util.*;

public class line2021_5 {
    public static void main(String[] args) {

        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -n 100 -s hi -e -e", "lien -s Bye"};

        boolean[] result = solution(program, flag_rules, commands);

        for(boolean r : result){
            System.out.println(r);
        }

    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
       
        flagSearch = new HashMap<>();  // flag과 해당 argument 연결
        for(int idx = 0; idx<flag_rules.length; idx++){ // flag_rules를 순환하면서 flagSearch에 입력
            String[] rule = flag_rules[idx].split(" ");
            flagSearch.put(rule[0], rule[1]);
        }

        for(int idx = 0; idx<commands.length; idx++){  // commands를 순환하면서 각 command에 대한 결과를 저장
            String[] command = commands[idx].split(" ");
            if (commandCheck(program, command)) {
                answer[idx] = true;
            }           
        }
        return answer;
    }

    static HashMap<String, String> flagSearch;
    static HashSet<String> usedFlag;   // 사용된 flag의 모음

    static boolean commandCheck(String program, String[] command) {

        usedFlag = new HashSet<>(); // 각 command 마다 usedFlag 초기화

        if (!command[0].equals(program)) { // program 일치여부 
            return false;
        }

        for (int idx = 1; idx < command.length; idx++) {  //command의 flag를 순회하면서 각 flag과 argument가 부합하는지 확인

            String flag = command[idx];

            if (!flagSearch.containsKey(command[idx])) {  // flag-rules에 
                return false;
            }

            if (usedFlag.contains(flag)) {
                return false;
            }
            usedFlag.add(flag);

            String argument_type = flagSearch.get(flag);
            switch (argument_type) { // flag에 대한 argument_type의 일치여부확인
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

            case "NULL":
                break;
            }
        }

        return true;
    }
}