import java.util.*;

public class line6 {

    static boolean[] finAp;

    public static void main(String[] args) {

        String[] companies = { "A fabdec 2", "B cebdfa 2", "C ecfadb 2" };
        String[] applicants = { "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" };

        // String[] str = solution(companies, applicants);

        // for (String s : str) {
        // System.out.println(s);
        // }

        solution(companies, applicants);

    }

    static String[] solution(String[] companies, String[] applicants) {
        String[] answer = new String[companies.length];

        finAp = new boolean[applicants.length];

        String[] com = new String[companies.length];

        while (true) {
            if (is_fin()) {
                break;
            }

            for(String person : applicants){

                String[] str = person.split(" ");

                if (!str[2].equals("0") ) {
                    com[str[1].charAt(Integer.parseInt(str[2])-1) - 'A'] += str[0];
                    str[2] = Integer.toString(Integer.parseInt(str[2])-1);
                }else{
                    finAp[str[0].charAt(0) - 'a'] = true;
                }
            }

            


        }

        return answer;
    }

    static boolean is_fin() {

        for (boolean f : finAp) {
            if (!f) {
                return false;
            }
        }
        return true;
    }
}
