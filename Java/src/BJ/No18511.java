package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class No18511 {
	static int[] a;
	static int n;
	static int k;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		a = new int[k];
		for (int i = 0; i < k; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		recur(0);
		System.out.println(result);
	}

	private static void recur(int now) {
		if (now > n)
			return;

		if (result < now)
			result = now;

		for (int i = k - 1; i >= 0; i--) {
			recur(now * 10 + a[i]);
		}
	}
}
