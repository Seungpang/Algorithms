package BJ;
// 선발 명단

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3980 {
    static int[][] ability;
    static boolean[] positionSelected;
    static int maxAbilitySum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ability = new int[11][11];
            positionSelected = new boolean[11];
            maxAbilitySum = 0;

            for (int i=0; i<11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<11; j++) {
                    ability[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backtrack(0, 0);

            System.out.println(maxAbilitySum);
        }
    }

    public static void backtrack(int playerIndex, int abilitySum) {
        if (playerIndex == 11) {
            maxAbilitySum=Math.max(maxAbilitySum,abilitySum);
            return;
        }

        for(int pos=0;pos<11;pos++){
            if(!positionSelected[pos] && ability[playerIndex][pos]!=0){
                positionSelected[pos]=true;
                backtrack(playerIndex+1,abilitySum+ability[playerIndex][pos]);
                positionSelected[pos]=false;
            }
        }
    }
}
