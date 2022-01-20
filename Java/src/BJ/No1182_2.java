package BJ;
//부분수열의 합
//재귀

import java.util.Scanner;

public class No1182_2 {

	static int n;
	static int s;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int ans = dfs(0, 0);
		if (s == 0) {
			ans -= 1;
		}
		System.out.println(ans);
	}

	private static int dfs(int i, int sum) {
		if (i == a.length) {
			if (sum == s) {
				return 1;
			} else {
				return 0;
			}
		}
		return dfs(i + 1, sum + a[i]) + dfs(i + 1, sum);
	}
}
