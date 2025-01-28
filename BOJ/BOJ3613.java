package boj;

import java.io.*;

/*
 * Java vs C++
 */
public class BOJ3613 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String parameter = br.readLine();

        boolean isJava = false;
        boolean isCpp = false;

        StringBuilder sb = new StringBuilder();
        sb.append(parameter.charAt(0));


        if (!Character.isLowerCase(parameter.charAt(0))
                || parameter.charAt(parameter.length() - 1) == '_') {
            isJava = true;
            isCpp = true;
        } else {

            for (int i = 1; i < parameter.length(); i++) {

                char c = parameter.charAt(i);

                if (Character.isUpperCase(c)) {
                    isJava = true;
                    sb.append('_').append(Character.toLowerCase(c));
                } else if (c == '_') {
                    isCpp = true;
                    i++;
                    c = parameter.charAt(i);
                    if (!Character.isLowerCase(c)) {
                        isJava = true;
                        break;
                    }
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }
        }


        if (isJava && isCpp) {
            System.out.println("Error!");
        } else {
            System.out.println(sb.toString());
        }



    }
}
