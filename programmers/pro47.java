package programmers;

public class pro47 {
    //스킬트리
    public static void main(String[] args) {

        String skill = "CBD";

        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
        
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int [] tree = new int[26];

        for(int i = 0; i<skill.length(); i++){
            tree[skill.charAt(i) - 'A'] = i+1;
        }

        for(int i = 0; i<skill_trees.length; i++){

            int count = 1;
            int[] sk = tree.clone();

            String s = skill_trees[i];

            boolean check = true;
            
            for(int j = 0; j<s.length(); j++){

                if (tree[s.charAt(j) - 'A'] == 0) {
                    continue;
                }

                if (tree[s.charAt(j) - 'A'] > count ) {
                    check = false;
                    break;
                }
                count++;
            }

            if (check) {
                answer++;
            }

        }

        return answer;
    }
}