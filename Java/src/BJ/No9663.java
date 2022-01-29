package BJ;
//N-Queen
//재귀

import java.util.Scanner;

public class No9663 {
	static boolean[][] a = new boolean[15][15];
	static int n;
	static int ans = 0;

	static boolean check(int row, int col) {
		for (int i = 0; i < n; i++) {
			if (i==row)
				continue;
			if (a[i][col]) {
				return false;
			}
		}

		int x = row - 1;
		int y = col - 1;
		while (x >= 0 && y >= 0) {
			if (a[x][y] == true) {
				return false;
			}
			x -= 1;
			y -= 1;
		}

		x = row - 1;
		y = col + 1;
		while (x >= 0 && y < n) {
			if (a[x][y] == true) {
				return false;
			}
			x -= 1;
			y += 1;
		}
		return true;
	}

	static void calc(int row) {
		if (row == n) {
			ans += 1;
		}
		for (int col = 0; col < n; col++) {
			a[row][col] = true;
			if (check(row, col)) {
				calc(row + 1);
			}
			a[row][col] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		calc(0);
		System.out.println(ans);
	}
}
