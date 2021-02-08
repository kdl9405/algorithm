package programmers;

import java.util.*;
/* 
    순위 검색

    // 효율성 통과 / 정확성에서 6개 런타임에러
    
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

    static HashMap<String, List<Integer>> hash;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        hash = new HashMap<>();

        // 1. 각 info를 16가지 경우의 수로 만들어 각각 점수를 집어넣음
        for (String i : info) {
            String temp = i.replaceAll("[0-9]", "");
            int point = Integer.parseInt(i.replaceAll("[^0-9]", ""));
            temp = temp.trim();
            to16case(temp, point);
        }

        // 2. 각 경우의 수에 들어가있는 점수를 정렬
        for (String k : hash.keySet()) {
            List<Integer> list = hash.get(k);
            Collections.sort(list);
            hash.put(k, list);
        }

        // 3. 각 쿼리에 맞는 점수 집합에서 해당 점수 이상의 개수를 탐색 후 answer에 할당
        int i = 0;
        for (String q : query) {
            String s = q.replaceAll("and", "");
            int point = Integer.parseInt(s.replaceAll("[^0-9]", ""));
            s = s.replaceAll("[^a-z-]", "");

            answer[i] = binarySearch(hash.get(s), point);
            i++;
        }

        return answer;
    }

    static void to16case(String info, Integer point) {

        String[] str = info.split(" ");

        Queue<String> queue = new LinkedList<>();
        queue.add(str[0]);
        queue.add("-");

        for (int i = 1; i < 4; i++) {

            Queue<String> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                String s = queue.poll();
                temp.add(s + str[i]);
                temp.add(s + "-");
            }
            
            queue.addAll(temp);
        }

        for (String s : queue) {

            List<Integer> list;

            if (hash.containsKey(s)) {
                list = hash.get(s);
            } else {
                list = new ArrayList<>();
            }

            list.add(point);

            hash.put(s, list);
        }
    }


    static int binarySearch(List<Integer> list, int point){

        if (list.isEmpty()) {
            return 0;
        }

        int index = list.size();

        int min = 0;
        int max = list.size()-1;

        while(min<=max){
            int mid = (min+max)/2;
            

            if (list.get(mid) >= point) {
                index = mid;
                max = mid-1;               
            }else{
                min = mid+1;
            }
        }

        return list.size()-index;
    }
}
