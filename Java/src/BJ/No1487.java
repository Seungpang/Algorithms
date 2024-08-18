package BJ;
// 물건 팔기

import java.util.Scanner;

public class No1487 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] customers = new int[n][2];
        for (int i = 0; i < n; i++) {
            customers[i][0] = sc.nextInt();
            customers[i][1] = sc.nextInt();
        }

        int maxProfit = Integer.MIN_VALUE;
        int bestPrice = 0;

        for (int i = 0; i < n; i++) {
            int price = customers[i][0];
            int profit = 0;

            for (int j = 0; j < n; j++) {
                if (customers[j][0] >= price) {
                    if (price - customers[j][1] > 0) {
                        profit += price - customers[j][1];
                    }
                }
            }
            if (profit > maxProfit) {
                maxProfit = profit;
                bestPrice = price;
            } else if (profit == maxProfit && price < bestPrice) {
                bestPrice = price;
            }
        }

        System.out.println(maxProfit > 0 ? bestPrice : 0);
    }
}
