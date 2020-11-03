package programmers;

import java.util.*;

/**
 * pro102
 */
public class pro102 {

    public static void main(String[] args) {

        String dirs = "ULURRDLLU";

        System.out.println(solution(dirs));

    }

    static int solution(String dirs) {
        int answer = 0;

        HashSet<HashSet<String>> set = new HashSet<>();

        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {

            int nx = x;
            int ny = y;

            switch (dirs.charAt(i)) {
                case 'U':
                    ny++;
                    break;
                case 'D':
                    ny--;
                    break;
                case 'L':
                    nx--;
                    break;
                case 'R':
                    nx++;
                    break;
            }
            if (Math.abs(nx) <= 5 && Math.abs(ny) <= 5) {
                HashSet<String> temp = new HashSet<>();
                temp.add(y + "," + x);
                temp.add(ny + "," + nx);

                if (!set.contains(temp)) {
                    answer++;
                    set.add(temp);
                }

                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}