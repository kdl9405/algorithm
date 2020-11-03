
package gooorm;

import java.util.*;

/**
 * nhn1
 */
public class nhn1 {

    public static void main(String[] args) {
        int numOfAllPlayers = 17;
        int numOfQuickPlayers = 5;
        char[] namesOfQuickPlayers = { 'B', 'D', 'I','M','F' };
        int numOfGames = 11;
        int[] numOfMovesPerGame = { 3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23 };

        solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
            int[] numOfMovesPerGame) {

        int[] count = new int[numOfAllPlayers];
        count[0] = 1;
        HashSet<Character> set = new HashSet<>();
        for (char q : namesOfQuickPlayers) {
            set.add(q);
        }

        char[] position = new char[numOfAllPlayers];
        for (int i = 1; i < numOfAllPlayers; i++) {
            position[i] = (char) ('A' + i);
        }

        int now = 1;
        char player = 'A';

        for (int i = 0; i < numOfGames; i++) {
            now += numOfMovesPerGame[i];

            if (now < 0) {
                now += (numOfAllPlayers-1)*10;
            }

            if (now > numOfAllPlayers - 1) {
                now %= numOfAllPlayers-1;                
            }   
            if (now == 0) {
                now = numOfAllPlayers-1;      
            }
            
            System.out.println("i = "+i+"   now = "+now+"    player  = "+player);

            if (set.contains(position[now])) {
                count[player - 'A']++;
            } else {
                char temp = player;
                player = position[now];
                position[now] = temp;
                System.out.println("temp = "+temp+"   now = "+now+"    player  = "+player);

                count[player - 'A']++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<numOfAllPlayers; i++){
            sb.append(position[i]+" "+count[position[i]-'A']+"\n");
        }
        sb.append(player+" "+count[player-'A']);
        System.out.println(sb);
    }
}