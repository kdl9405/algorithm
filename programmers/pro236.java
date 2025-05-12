package programmers;

import java.util.*;

// 2021 KAKAO BLIND RECRUITMENT
// 매출 하락 최소화

public class pro236 {

    public static void main(String[] args) {

        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};

        int[][] links =
                {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};

        System.out.println(solution(sales, links));
    }

    static int[][] dp;
    static List<Integer>[] tree;
    static int[] salesData;

    public static int solution(int[] sales, int[][] links) {

        int n = sales.length;
        dp = new int[n + 1][2];
        salesData = sales;
        tree = buildTree(n, links);

        calculateMinLoss(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    private static List<Integer>[] buildTree(int n, int[][] links) {
        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        for (int[] link : links) {
            tree[link[0]].add(link[1]);
        }
        return tree;
    }

    private static void calculateMinLoss(int node) {
        dp[node][1] = salesData[node - 1]; // 참석 시 손해
        dp[node][0] = 0;

        if (tree[node].isEmpty())
            return;

        int additionalCost = Integer.MAX_VALUE;
        boolean hasAttendingChild = false;

        for (int child : tree[node]) {
            calculateMinLoss(child);

            dp[node][0] += Math.min(dp[child][0], dp[child][1]);
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);

            if (dp[child][1] < dp[child][0]) {
                hasAttendingChild = true;
            } else {
                additionalCost = Math.min(additionalCost, dp[child][1] - dp[child][0]);
            }
        }

        if (!hasAttendingChild) {
            dp[node][0] += additionalCost;
        }
    }


    /*
     * // 팀별 인원 구분하기 // 브루드포스로,, 참여인원별 최소 매출 합계 구하기.
     * 
     * // 시간초과
     * 
     * public static int solution(int[] sales, int[][] links) {
     * 
     * Map<Integer, Set<Integer>> teams = findTeams(links); int[] leaders =
     * teams.keySet().stream().mapToInt(i -> i).toArray(); workShopMembers = new
     * int[leaders.length]; salesSum = Integer.MAX_VALUE;
     * 
     * findWorkshopMembers(leaders, teams, 0, sales);
     * 
     * return salesSum; }
     * 
     * public static int[] workShopMembers; public static int salesSum;
     * 
     * private static Map<Integer, Set<Integer>> findTeams(int[][] links) { Map<Integer,
     * Set<Integer>> teams = new HashMap<>();
     * 
     * for (int[] link : links) { int leader = link[0]; int member = link[1];
     * 
     * if (!teams.containsKey(leader)) {
     * 
     * Set<Integer> members = new HashSet<>(); members.add(leader); teams.put(leader, members);
     * 
     * }
     * 
     * teams.get(leader).add(member); }
     * 
     * return teams; }
     * 
     * private static void findWorkshopMembers(int[] leaders, Map<Integer, Set<Integer>> teams, int
     * index, int[] sales) {
     * 
     * if (index == leaders.length) { updateMinSales(sales); return; }
     * 
     * for (int members : teams.get(leaders[index])) { workShopMembers[index] = members;
     * findWorkshopMembers(leaders, teams, index + 1, sales); } }
     * 
     * private static void updateMinSales(int[] sales) { int sum = 0;
     * 
     * HashSet<Integer> memberSet = new HashSet<>(); for (int member : workShopMembers) {
     * memberSet.add(member); }
     * 
     * for (int member : memberSet) { sum += sales[member - 1]; }
     * 
     * System.out.println(memberSet + "  ->  " + sum);
     * 
     * salesSum = Math.min(sum, salesSum); }
     */
}
