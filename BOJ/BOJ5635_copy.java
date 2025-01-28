package boj;

/**
 * 생일
 */

import java.io.*;
import java.util.*;

public class BOJ5635_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Info[] birthdays = new Info[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            birthdays[i] = new Info(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(birthdays);
        System.out.println(birthdays[N - 1].name + "\n" + birthdays[0].name);
    }

    private static class Info implements Comparable<Info> {

        String name;
        int day;
        int month;
        int year;

        Info(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Info o) {

            if (o.year == year) {

                if (o.month == month) {
                    return day - o.day;
                }
                return month - o.month;
            }

            return year - o.year;
        }

    }

}
