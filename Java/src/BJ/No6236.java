package BJ;
// 용돈 관리

import java.util.Scanner;

public class No6236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] expenses = new int[N];
        int maxExpense = 0;
        int totalExpense = 0;
        for (int i = 0; i < N; i++) {
            expenses[i] = sc.nextInt();
            maxExpense = Math.max(maxExpense, expenses[i]);
            totalExpense += expenses[i];
        }

        int left = maxExpense;
        int right = totalExpense;
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canManage(mid, expenses, M)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean canManage(int amount, int[] expenses, int required) {
        int count = 1;
        int curr = amount;

        for (int expense : expenses) {
            if (curr < expense) {
                count++;
                curr = amount;
            }
            curr -= expense;

            if (count > required) {
                return false;
            }
        }

        return true;
    }
}
