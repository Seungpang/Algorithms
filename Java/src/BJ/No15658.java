package BJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No15658 {

	static int n;
	static int[] a;

	static class Pair {
		int max, min;

		public Pair(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int mul = sc.nextInt();
		int div = sc.nextInt();
		Pair ans = calc(1, a[0], plus, minus, mul, div);
		System.out.println(ans.max);
		System.out.println(ans.min);
	}

	private static Pair calc(int i, int cur, int plus, int minus, int mul, int div) {
		if (i == n) {
			return new Pair(cur, cur);
		}

		List<Pair> res = new ArrayList<>();
		if (plus > 0) {
			res.add(calc(i + 1, cur + a[i], plus - 1, minus, mul, div));
		}
		if (minus > 0) {
			res.add(calc(i + 1, cur - a[i], plus, minus - 1, mul, div));
		}
		if (mul > 0) {
			res.add(calc(i + 1, cur * a[i], plus, minus, mul - 1, div));
		}
		if (div > 0) {
			res.add(calc(i + 1, cur / a[i], plus, minus, mul, div - 1));
		}

		Pair ans = res.get(0);
		for (Pair p : res) {
			if (ans.max < p.max) {
				ans.max = p.max;
			}
			if (ans.min > p.min) {
				ans.min = p.min;
			}
		}

		return ans;
	}
}
