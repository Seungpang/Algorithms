package Programmers;
// n진수 게임
public class PG17687 {

    public static void main(String[] args) {
        final PG17687 pg17687 = new PG17687();
        System.out.println(pg17687.solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        while (sb.toString().length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        String s = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(s.charAt(p - 1 + i * m));
        }

        return sb.toString().toUpperCase();
    }
}
