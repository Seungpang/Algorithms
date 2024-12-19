package BJ;
// 랭퍼든 수열쟁이야!!

import java.util.Scanner;

public class No15918 {

    static int n, x, y;
    static int[] arr;
    static boolean[] used;
    static long count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        arr = new int[2 * n];
        used = new boolean[n + 1];

        int forcedK = (y - x - 1);

        if (forcedK < 1 || forcedK > n) {
            System.out.println(0);
            return;
        }

        arr[x - 1] = forcedK;
        arr[y - 1] = forcedK;
        used[forcedK] = true;

        count = 0;
        backtrack(n);

        System.out.println(count);
    }

    private static void backtrack(int k) {
        if (k == 0) {
            count++;
            return;
        }

        if (used[k]) {
            backtrack(k - 1);
            return;
        }

        for (int i = 0; i < 2 * n; i++) {
            int j = i + k + 1;
            if (j >= 2 * n) {
                break;
            }

            if (arr[i] == 0 && arr[j] == 0) {
                arr[i] = k;
                arr[j] = k;
                used[k] = true;

                backtrack(k - 1);

                arr[i] = 0;
                arr[j] = 0;
                used[k] = false;
            }
        }
    }
}
