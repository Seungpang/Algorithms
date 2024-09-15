package BJ;
// 점프점프

import java.util.Scanner;

public class No14248 {

    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = sc.nextInt();

        visited  = new boolean[n+1];
        dfs(start);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int index) {
        if (index < 1 || index > n) {
            return;
        }

        visited[index] = true;
        dfs(index + arr[index]);
        dfs(index - arr[index]);
    }
}
