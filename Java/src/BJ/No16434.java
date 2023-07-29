package BJ;
// 드래곤 앤 던전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16434 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long soldierAttack = Long.parseLong(st.nextToken());
        long soldierHP = 0, soldierMaxHP = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            if (t == 1) {
                soldierHP += attack * ((hp / soldierAttack) - (hp % soldierAttack != 0 ? 0 : 1));
                soldierMaxHP = Math.max(soldierMaxHP, soldierHP);
            } else {
                soldierAttack += attack;
                soldierHP = Math.max(soldierHP - hp, 0);
            }
        }

        soldierMaxHP++;

        System.out.println(soldierMaxHP);
    }
}
