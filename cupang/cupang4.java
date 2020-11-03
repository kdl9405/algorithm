import java.util.*;

public class cupang4 {

    public static void main(String[] args) {
        String[][] roads = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
                { "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
                { "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
                { "BUSAN", "YEOSU" } };

        String depar = "SEOUL";
        String hub = "DAEGU";
        String dest = "YEOSU";

        System.out.println(solution(depar, hub, dest, roads));

    }

    static int solution(String depar, String hub, String dest, String[][] roads) {
        int answer = 1;

        city = new HashMap<>();

        int i = 0;
        for (String[] r : roads) {
            if (!city.containsKey(r[0])) {
                city.put(r[0], i++);
            }
            if (!city.containsKey(r[1])) {
                city.put(r[1], i++);
            }
        }

        visit = new boolean[city.size()];
        count = 0;
        find_route(depar, hub, roads);
        answer = count;
        count = 0;
        Arrays.fill(visit, false);
        find_route(hub, dest, roads);

        answer *= count;
        return answer;
    }

    static HashMap<String, Integer> city;
    static boolean[] visit;
    static int count;

    static void find_route(String depar, String dest, String[][] roads) {
        if (depar.equals(dest)) {
            count++;
            return;
        }

        for(String[] road : roads){
            if (road[0].equals(depar) && !visit[city.get(road[1])]) {
                visit[city.get(road[1])] = true;
                find_route(road[1], dest, roads);
                visit[city.get(road[1])] = false;
            }
        }     

    }
}
