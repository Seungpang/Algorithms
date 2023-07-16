package BJ;
// 부분합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1806 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(numbers));

		int left = 0;
		int right = 0;
		int sum = numbers[0];
		int result = N + 1;
		while (left <= right && right < N) {
			if (sum < S) {
				right++;
				sum += numbers[right];
			} else if (sum == S) {
				result = Math.min(right - left + 1, result);
				right++;
				sum += numbers[right];
			} else if (sum > S) {
				result = Math.min(right - left + 1, result);
				sum -= numbers[left];
				left++;
			}
		}
		if (result > N) {
			result = 0;
		}
		System.out.println(result);
	}
}
