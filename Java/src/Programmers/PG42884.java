package Programmers;
// 단속 카메라
import java.util.Arrays;

public class PG42884 {

    public static void main(String[] args) {
        final PG42884 pg42884 = new PG42884();
        System.out.println(pg42884.solution(new int[][]{
                {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
        }));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        int idx = 0;

        while (idx < routes.length) {
            count++;
            int end = routes[idx][1];
            while (idx < routes.length && routes[idx][0] <= end) {
                idx++;
            }
        }

        return count;
    }
}
