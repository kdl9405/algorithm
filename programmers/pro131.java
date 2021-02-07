package programmers;

import java.util.Arrays;

/* 
    순위 검색

    
*/

public class pro131 {

    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
        int[] answer = solution(info, query);

        for (int a : answer) {
            System.out.println(a);
        }

        // String s1 = "java bac 150";
        // String s2 = "java ... 150";
        // System.out.println(s1.replaceAll("[^a-z]", ""));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] infoArr = new String[info.length][5];
        int i = 0;
        for (String[] arr : infoArr) {
            String[] str = info[i].split(" ");
            for (int j = 0; j < 5; j++) {
                arr[j] = str[j];
            }
            i++;
        }

        Arrays.sort(infoArr, (a1, a2) -> {
            if (a2[4].equals(a1[4])) {
                if (a1[0].equals(a2[0])) {
                    if (a1[1].equals(a2[1])) {
                        if (a1[2].equals(a2[2])) {
                            return a1[3].compareTo(a2[3]);
                        }
                        return a1[2].compareTo(a2[2]);
                    }
                    return a1[1].compareTo(a2[1]);
                }
                return a1[0].compareTo(a2[0]);
            }
            return Integer.parseInt(a2[4]) - Integer.parseInt(a1[4]);
        });

        // i = 0;
        // for (String[] arr : infoArr) {
        //     for (int j = 0; j < 5; j++) {
        //         System.out.print(arr[j] + " ");
        //     }
        //     System.out.println("");
        //     i++;
        // }

        for (int j = 0; j < query.length; j++) {

            query[j] = query[j].replaceAll(" and","");
            String[] str = query[j].split(" ");            
            int point = Integer.parseInt(str[4]);

            int count = 0;
            for (String[] a : infoArr) {

                if (Integer.parseInt(a[4]) < point) {
                    break;
                }

                count++;
            }
            answer[j] = count;
        }
        return answer;
    }
}
