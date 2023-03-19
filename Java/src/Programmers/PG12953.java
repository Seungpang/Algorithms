package Programmers;
// N개의 최소공배수
public class PG12953 {

    public static void main(String[] args) {
        final PG12953 pg12953 = new PG12953();
        System.out.println(pg12953.solution(new int[]{2, 6, 8, 14}));
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        int c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
