package BJ;
// 에리 - 카드

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No15728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> card = new ArrayList<>();
        List<Integer> teamCard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            card.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            teamCard.add(sc.nextInt());
        }

        int max = 0, idx = -1;
        for (int z = 0; z<k; z++) {
            max = Integer.MIN_VALUE;
            idx = -1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<teamCard.size(); j++) {
                    if (max < card.get(i) * teamCard.get(j)) {
                        max = card.get(i) * teamCard.get(j);
                        idx = j;
                    }
                }
            }
            teamCard.remove(idx);
        }

        max = card.get(0) * teamCard.get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < teamCard.size(); j++) {
                max = Math.max(max, card.get(i) * teamCard.get(j));
            }
        }

        System.out.println(max);
    }
}
