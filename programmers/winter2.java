package programmers;

/**
 * winter2
 */
public class winter2 {

    public static void main(String[] args) {

        String encrypted_text = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = 3;
       
        System.out.println(solution(encrypted_text, key, rotation));
      
    }

    static String solution(String encrypted_text, String key, int rotation) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        rotation %= key.length();
        int r = rotation;

        if(r<0){
            r+=key.length();
        }
       
        for (int i = 0; i < encrypted_text.length(); i++) {
            int j = (i + r) % encrypted_text.length();

            sb.append(encrypted_text.charAt(j));
        }

        encrypted_text = sb.toString();

        sb = new StringBuilder();

        for (int i = 0; i < encrypted_text.length(); i++) {
            int n = encrypted_text.charAt(i) - 'a';
            n -= (key.charAt(i) - 'a' + 1);
            n %= 26;
            if (n < 0) {
                n += 26;
            }
            n += 'a';
            sb.append((char) n);
        }

        System.out.println(sb.toString());

        answer = sb.toString();

        return answer;
    }

}