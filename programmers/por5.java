
public class por5 {
    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i< phone_book.length; i++){
            for(int j = 0; j<phone_book.length; j++){
                if(i == j){
                    continue;
                } else {
                    if(check(phone_book[i], phone_book[j])){
                        answer = false;
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }

    static boolean check(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
