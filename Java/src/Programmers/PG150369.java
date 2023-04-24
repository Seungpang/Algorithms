package Programmers;
// 택배 배달과 수거하기

public class PG150369 {

    public static void main(String[] args) {
        final PG150369 pg150369 = new PG150369();
        System.out.println(pg150369.solution(4,5,new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(pg150369.solution(2,7,new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int give = 0;
        int get = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (give < deliveries[i] || get < pickups[i]) {
                    cnt++;
                    give += cap;
                    get += cap;
                }
                give -= deliveries[i];
                get -= pickups[i];
                answer += (long) (i + 1) * cnt * 2;
            }
        }
        return answer;
    }
}
