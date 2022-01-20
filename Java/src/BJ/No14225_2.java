package BJ;

import java.util.Scanner;

public class No14225_2 {

	static boolean[] c = new boolean[20 * 100000 + 10];
	static int[] a = new int[20];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		dfs(0, 0);
		for (int i = 1; ; i++) {
			if (c[i] == false) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void dfs(int i, int sum) {
		if (i == n) {
			c[sum] = true;
			return;
		}
		dfs(i + 1, sum + a[i]);
		dfs(i + 1, sum);
	}
}
