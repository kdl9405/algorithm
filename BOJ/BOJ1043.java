package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 거짓말
 * 
 * 1) 사람별로 참여하는 party를 등록하고 2) 진실을 아는 사람부터 진실을 전염시킨다는 개념으로 체크 (사람 -> 파티 / 파티 ->
 * 사람의 탐색이 가능해야함) 3) 체크 안된 party의 개수가 답.
 * 
 */
public class BOJ1043 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> truth = new HashSet<>();
        int c = Integer.parseInt(st.nextToken());
        while (c-- > 0) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        party_people = new ArrayList<>();
        people_party = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            people_party.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            party_people.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            while (c-- > 0) {
                int p = Integer.parseInt(st.nextToken());
                party_people.get(i).add(p);
                people_party.get(p).add(i);
            }
        }

        check_party = new boolean[m];

        for(Integer t : truth){
            speakTruth(t);
        }

        int count = 0;
        for(boolean check : check_party){
            if (!check) {
                count++;
            }
        }

        System.out.println(count);

    }

    static List<List<Integer>> party_people;
    static List<List<Integer>> people_party;
    static boolean[] check_party;

    static void speakTruth(int p) {

        for (int party : people_party.get(p)) {
            if (check_party[party]) {
                continue;
            }
            check_party[party] = true;

            for (int people : party_people.get(party)) {
                if (people == p) {
                    continue;
                }
                speakTruth(people);
            }
        }
    }
}