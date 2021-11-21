package programmers.winter2021;

import java.util.*;

public class sol3 {

    public static void main(String[] args) {

    }

    public int solution(String[] cakes, int[] cut_rows, int[] cut_columns) {
        int answer = 0;

        int[] row = new int[cut_rows.length + 2];
        int[] col = new int[cut_columns.length + 2];

        for (int i = 0; i < cut_rows.length; i++) {
            row[i + 1] = cut_rows[i];
        }
        row[row.length - 1] = cakes.length;

        for (int i = 0; i < cut_columns.length; i++) {
            col[i + 1] = cut_columns[i];
        }
        col[col.length - 1] = cakes.length;
       
        HashSet<Character> count;

        for(int i = 0; i<row.length-1; i++){

            for(int j = 0; j<col.length-1; j++){

                count = new HashSet<>();

                for(int r = row[i]; r<row[i+1]; r++){
                    for(int c = col[j]; c<col[j+1]; c++){
                        count.add(cakes[r].charAt(c));
                    }
                } 

                answer = Math.max(answer, count.size());
            }
        }

        return answer;
    }

}
