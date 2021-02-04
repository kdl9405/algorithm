package programmers;

/* 
    브라이언의 고민

*/
public class pro123_copy {
    public static void main(String[] args) {

        String sentence = "SpIpGpOpNpGJqOqA";

        System.out.println(solution(sentence));
    }

    static String solution(String sentence) {
        String answer = "invalid";

        if (sentence.contains(" ")) {
            return answer;
        }

        lowerAlphabet = new int[26];

        for(int i = 0; i<sentence.length(); i++){
            char c = sentence.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerAlphabet[c-'a']++;
            }
        }

        usedAlphabet = new boolean[26];
        boolean ruleOne = false;
        ruleTwo = false;

        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        int endIdx = 0;

        while (startIdx < sentence.length()) {
            if (Character.isLowerCase(sentence.charAt(startIdx))) { // 단어의 시작이 소문자라면
                char c = sentence.charAt(startIdx); 

                if (usedAlphabet[c-'a'] || lowerAlphabet[c-'a'] != 2) { // 사용된 소문자인지 or 개수가 2개인지(규칙2 사용불가) 체크
                    return answer;
                }

                for(int i = startIdx+1; i<sentence.length(); i++){
                    if (sentence.charAt(i) == c) {
                        String word = sentence.substring(startIdx+1, i);
                        usedAlphabet[c-'a'] = true;
                        ruleTwo = true;

                        // word 체크 - 규칙2는 불가해야하고, 규칙1이 사용되었으면 규칙 1 체크
                        word = checkWord(word);
                     
                        if (word.equals("0")) {
                            return answer;
                        }

                        ruleTwo = false;
                        sb.append(word+" ");
                        startIdx = i+1;
                        break;                
                    }
                }
            }else{ // 단어의 시작이 대문자라면
                for(int i = startIdx+1; i<sentence.length(); i++){
                    if (C) {
                        
                    }
                }
            }
        }        

        answer = sb.toString().trim();
        return answer;
    }

    static int[] lowerAlphabet;
    static boolean[] usedAlphabet;
    static boolean ruleTwo;

    static String checkWord (String word){
        
        if (Character.isLowerCase(word.charAt(0)) && ruleTwo) {
            return "0";
        }

        // 규칙 1 체크후 제거

        if (word.length()>2 && Character.isLowerCase(word.charAt(1))) { // 규칙1 사용 체크
            
            char c = word.charAt(1);

            if (usedAlphabet[c-'a']) {
                return "0";
            }

            for(int i = 1; i<word.length(); i+=2){
                if (word.charAt(i) != c) {
                    return "0";
                }
                lowerAlphabet[c-'a']--;
                if (lowerAlphabet[c-'a'] < 0) {
                    return "0";
                } 
            }            
            word = word.replaceAll(Character.toString(c), "");
            usedAlphabet[c-'a'] = true;

        }

        // 소문자가 있으면 wrong;
        for(int i = 0; i<word.length(); i++){    
            if (Character.isLowerCase(word.charAt(i))) {
                return "0";
            }
        }
        
        return word;
    }

}
