package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class No2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == m) {
						max = a[i] + a[j] + a[k];
						break;
					}
					if (a[i] + a[j] + a[k] <= m && max < a[i]+ a[j] + a[k]) {
						max = a[i] + a[j] + a[k];
					}
				}
			}
		}
		System.out.println(max);
	}
}
