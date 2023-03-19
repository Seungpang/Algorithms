package Programmers;
// 점프와 순간 이동
public class PG12980 {

    public static void main(String[] args) {
        final PG12980 pg12980 = new PG12980();
        System.out.println(pg12980.solution(5000));
    }

    public int solution(int n) {
        int ans = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
                ans++;
            }
        }
        return ans;
    }
}
