package BJ;
// 소가 길을 건너간 이유 1

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No14467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> cows = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cowNum = sc.nextInt();
            int point = sc.nextInt();
            if (!cows.containsKey(cowNum)) {
                cows.put(cowNum, point);
            } else {
                if (cows.get(cowNum) != point) {
                    ans++;
                    cows.put(cowNum, point);
                }
            }
        }
        System.out.println(ans);
    }
}
