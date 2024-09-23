package BJ;
// 양팔저울

import java.util.Scanner;

public class No17610 {

    static boolean[] check;
    static int[] arr;
    static int k, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        arr = new int[k];
        sum = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        check = new boolean[sum + 1];
        dfs(0, 0);

        int result = 0;
        for (int i = 1; i <= sum; i++) {
            if (!check[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int index, int curr) {
        if (index > k) return;
        if (index == k) {
            if (curr > 0 && curr <= sum) {
                check[curr] = true;
            }
            return;
        }
        dfs(index + 1, curr + arr[index]);
        dfs(index + 1, curr - arr[index]);
        dfs(index + 1, curr);
    }
}
