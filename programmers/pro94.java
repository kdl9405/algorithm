package programmers;

/**
 *  스킬체크 레벨2 - 2
 */
public class pro94 {

    public static void main(String[] args) {

        String name = "BBBAABBBBBB";

        System.out.println(solution(name));

    }

    static int solution(String name) {
        int answer = 0;

        int count = 0;
        int max = 0;
        int index = 0;
        for(int i = 0; i<name.length(); i++){
            if (name.charAt(i) == 'A') {
                count++;
            }else{
                if (count != 0) {
                  max = Math.max(max, count);
                  if (max == count) {
                      index = i-count;
                  }
                  count = 0;
                }
            }

            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
        }

        if (count == name.length()) {
            return 0;
        }


        if (max == 0) {
            return answer+name.length()-1;
        }

        int left = index-1;
        if (left < 1) {
            left = 0;
        }
        int right = name.length()-(index+max);
       
        answer+= (left + right);
        answer+= Math.min(Math.min(left, right), max);
        
        return answer;
    }
}