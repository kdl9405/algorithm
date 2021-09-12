package nexon;

import java.util.*;

public class test3 {

    public static void main(String[] args) {

    }

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1,
        List<Integer> students2) {

        List<Integer> list = new ArrayList<>();

        groupNum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            groupNum[i] = i;
        }

        groupSize = new int[n + 1];
        Arrays.fill(groupSize,1);


        for(int i = 0; i<queryType.size(); i++){

            int a = findGroup(students1.get(i));
            int b = findGroup(students2.get(i));

            if (queryType.get(i).equals("Friend")) {

                if (a != b) {
                    if (a < b) {
                        groupNum[b] = a;
                        groupSize[a] += groupSize[b];
                    }else{
                        groupNum[a] = b;
                        groupSize[b] += groupSize[a];
                    }
                }
                
            }else{
                if (a == b) {
                    list.add(groupSize[a]);
                }else{
                    list.add(groupSize[a]+groupSize[b]);
                }
            }
        }


        return list;
    }

    static int[] groupNum;
    static int[] groupSize;

    static int findGroup(int n) {
        if (groupNum[n] == n) {
            return n;
        }
        return groupNum[n] = findGroup(groupNum[n]);
    }
}
