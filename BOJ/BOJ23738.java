package boj;

import java.io.*;

/*
 * Ресторан
 */
public class BOJ23738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();


        for (char c : name.toCharArray()) {
            System.out.print(change(c));
        }
    }

    static String change(char c) {

        String s = Character.toString(Character.toLowerCase(c));

        switch (c) {
            case 'B':
                s = "v";
                break;

            case 'E':
                s = "ye";
                break;

            case 'H':
                s = "n";
                break;

            case 'P':
                s = "r";
                break;

            case 'C':
                s = "s";
                break;

            case 'Y':
                s = "u";
                break;

            case 'X':
                s = "h";
                break;



        }

        return s;
    }


}
