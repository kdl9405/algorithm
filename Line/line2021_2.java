package Line;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class line2021_2 {
    public static void main(String[] args) {
        String inp_str = "aaaaZZZZ)";

        int[] resutl = solution(inp_str);
        for(int r : resutl){
            System.out.print(r+" ");
        }
    }

    static int[] solution(String inp_str) {
        
        List<Integer> result = new LinkedList<>();         

        if (inp_str.length()<8 || inp_str.length()>15) {
            result.add(1);
        }

        String test2 = inp_str.replaceAll("[A-Za-z0-9~!@#$%^&*]", "");
        if (test2.length()>0) {
            result.add(2);
        }

        int count = 0;
        int len = inp_str.length();
        if (inp_str.replaceAll("[A-Z]", "").length() < len) {
            count++;
        }
        if (inp_str.replaceAll("[a-z]", "").length() < len) {
            count++;
        }
        if (inp_str.replaceAll("[0-9]", "").length() < len) {
            count++;
        }
        if (inp_str.replaceAll("[~!@#$%^&*]", "").length() < len) {
            count++;
        }

        if (count <3) {
            result.add(3);
        }

        Matcher test4 = Pattern.compile("(\\w)\\1\\1\\1").matcher(inp_str);
        if (test4.find()) {
            result.add(4);
        }

        HashMap<Character, Integer> test5 = new HashMap<>();
        for(int i = 0; i<inp_str.length(); i++){
            test5.put(inp_str.charAt(i), test5.getOrDefault(inp_str.charAt(i), 0)+1);
            if (test5.get(inp_str.charAt(i))>=5) {
                result.add(5);
                break;
            }
        } 
        
        int[] answer;
        
        if (result.isEmpty()) {
            answer = new int[]{0};
        }else{
            answer = result.stream().mapToInt(i->i).toArray();
        }
        
        return answer;
    }
}
