package BJ;

import java.util.Scanner;

public class No6603_3 {

	static int n;
	static int[] a;
	static boolean[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n==0)
				break;
			a = new int[n];
			result = new boolean[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			dfs(0, 0);
			System.out.println();
		}


	}

	private static void dfs(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < n; i++) {
				if (result[i]) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
		}
		for (int i = start; i < n; i++) {
			result[i] = true;
			dfs(i + 1, depth + 1);
			result[i] = false;
		}
	}
}
