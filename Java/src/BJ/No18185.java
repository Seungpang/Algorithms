package BJ;
// 라면 사기 (Small)

import java.util.Scanner;

public class No18185 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N + 2];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long cost = 0;
        for (int i = 0; i < N; i++) {
            if (A[i + 1] > A[i + 2]) {
                int min = Math.min(A[i], A[i + 1] - A[i + 2]);
                cost += 5 * min;
                A[i] -= min;
                A[i + 1] -= min;

                int min2 = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
                cost += 7 * min2;
                A[i] -= min2;
                A[i + 1] -= min2;
                A[i + 2] -= min2;
            } else {
                int min = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
                cost += 7 * min;
                A[i] -= min;
                A[i + 1] -= min;
                A[i + 2] -= min;

                int min2 = Math.min(A[i], A[i + 1]);
                cost += 5 * min2;
                A[i] -= min2;
                A[i + 1] -= min2;
            }
            cost += 3 * A[i];
            A[i] = 0;
        }
        System.out.println(cost);
    }
}
