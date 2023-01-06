package codingInterview;

import java.util.Arrays;

public class LC1833 {

    public static void main(String[] args) {
        final LC1833 lc1833 = new LC1833();
        System.out.println(lc1833.maxIceCream1(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(lc1833.maxIceCream2(new int[]{1, 3, 2, 4, 1}, 7));

    }

    //정렬 이용해서 풀기
    //시간복잡도 O(nlogn)
    //공간복잡도 O(logn)  자바에서 사용되는 정렬알고리즘이 퀵소트의 변형
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                coins -= cost;
                count++;
            }
        }
        return count;
    }

    //계수 정렬을 이용해서 풀기
    // n = costs.length;
    //시간 복잡도 O(n + m)
    //공간복잡도 O(m)
    public int maxIceCream2(int[] costs, int coins) {
        int m = costs[0];
        for (int cost : costs) {
            m = Math.max(m, cost);
        }

        int[] costsFrequency = new int[m + 1];
        for (int cost : costs) {
            costsFrequency[cost]++;
        }

        int iceCreams = 0;
        for (int cost = 1; cost <= m; cost++) {
            if (costsFrequency[cost] == 0) {
                continue;
            }

            if (coins < cost) {
                break;
            }

            int count = Math.min(costsFrequency[cost], coins / cost);
            coins -= cost * count;
            iceCreams += count;
        }
        return iceCreams;
    }
}
