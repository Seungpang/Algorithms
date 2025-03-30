package BJ;
// 카드 게임 (Easy)

import java.util.Scanner;

public class No32141 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int result = calculateMaxCards(N, H, cards);
        System.out.println(result);
    }

    private static int calculateMaxCards(int n, int h, int[] cards) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (h <= 0) {
                return count;
            }
            h -= cards[i];
            count++;
        }

        return h <= 0 ? count : -1;
    }
}
