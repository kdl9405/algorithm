package programmers;

import java.util.*;

/**
 * 스킬체크 레벨2 - 4 오픈채팅방
 */
public class pro96 {

    public static void main(String[] args) {

    }

    static String[] solution(String[] record) {
        String[] answer = {};
        
        String[][] arr= new String[record.length][2];
        
        HashMap<String, String> map = new HashMap<>();
        
        int count = 0;
        for(int i = 0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Change")){
                map.remove(str[1]);
                map.put(str[1], str[2]);
            }else {
                arr[count][0] = str[1];
                if(str[0].equals("Enter")){
                    map.remove(str[1]);
                    map.put(str[1], str[2]);
                    arr[count][1] = "들어왔습니다.";                    
                }else{
                    arr[count][1] = "나갔습니다.";
                }
                count++;
            }
        }
        answer = new String[count];
        for(int i = 0; i<count; i++){
            answer[i] = map.get(arr[i][0])+"님이 "+arr[i][1];
        }
        
        return answer;
    }
}