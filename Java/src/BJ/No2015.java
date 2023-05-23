package BJ;
// 수들의 합 4
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Long> map = new HashMap<>();
        int[] preSum = new int[n + 1];
        long result = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = sc.nextInt() + preSum[i - 1];
            if (preSum[i] == k) {
                result++;
            }
            if (map.containsKey(preSum[i] - k)) {
                result += map.get(preSum[i] - k);
            }
            if (!map.containsKey(preSum[i])) {
                map.put(preSum[i], 1L);
            } else {
                map.put(preSum[i], map.get(preSum[i]) + 1);
            }
        }
        System.out.println(result);
    }
}
