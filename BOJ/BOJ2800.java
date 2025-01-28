package boj;

import java.util.*;

/*
 * 괄호 제거
 */

public class BOJ2800 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        char[] expression = new char[st.length()];

        brackets = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int i = 0; i < st.length(); i++) {

            expression[i] = st.charAt(i);

            if (st.charAt(i) == '(') {
                brackets.add(new bracket(i));
                stack.add(index);
                index++;
            }
            if (st.charAt(i) == ')') {
                brackets.get(stack.pop()).rihgt = i;
            }
        }

        hashSet = new HashSet<>();

        makeNewExpression(0, expression);

        String[] result = new String[(hashSet.size())];

        hashSet.toArray(result);

        Arrays.sort(result);

        for (String s : result) {
            if (s.equals(st)) {
                continue;
            }
            System.out.println(s);
        }
    }

    static HashSet<String> hashSet;
    static ArrayList<bracket> brackets;

    static void makeNewExpression(int idx, char[] exp) {
        if (idx >= brackets.size()) {
            String temp = new String(exp);
            temp = temp.replaceAll(" ", "");
            hashSet.add(temp);
            return;
        }

        makeNewExpression(idx + 1, exp);

        exp[brackets.get(idx).left] = ' ';
        exp[brackets.get(idx).rihgt] = ' ';
        makeNewExpression(idx + 1, exp);

        exp[brackets.get(idx).left] = '(';
        exp[brackets.get(idx).rihgt] = ')';
        makeNewExpression(idx + 1, exp);

    }

}


class bracket {
    int left;
    int rihgt;

    public bracket(int left) {
        this.left = left;
    }
}
