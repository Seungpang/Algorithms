package Programmers;
//약수의 개수와 덧셈

public class PG77884 {
	public static void main(String[] args) {
		final PG77884 pg77884 = new PG77884();
		int left = 13;
		int right = 17;
		System.out.println(pg77884.solution(left, right)); //43

	}
	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i<=right; i++) {
			if (findDivisor(i) % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}
		return answer;
	}

	public int findDivisor(int num) {
		int cnt = 0;
		for (int i=1; i * i <=num; i++) {
			if (i*i == num) {
				cnt++;
			} else if (num % i == 0) {
				cnt += 2;
			}
		}
		return cnt;
	}
}
