package boj;

/*
 * 회사에 있는 사람
 */

import java.io.*;
import java.util.*;

public class BOJ7785 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ7785().solution();
    }

    void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> inOffice = new TreeSet<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                inOffice.add(name);
            } else {
                inOffice.remove(name);
            }
        }

        List<String> list = new ArrayList<>(inOffice);

        StringBuilder sb = new StringBuilder();

        ListIterator listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious()) {
            sb.append(listIterator.previous()).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
