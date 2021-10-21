package Programmers;
//2021 Dev-Matching
//다단계 칫솔 판매

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG77486 {

    public static void main(String[] args) {
        PG77486 a = new PG77486();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(a.solution(enroll, referral, seller, amount)));
        //360, 958, 108, 0, 450, 18, 180, 1080
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i];

            while (!now.equals("-")) {
                int parentProfit = profit / 10;
                int myProfit = profit - parentProfit;

                answer[indexMap.get(now)] += myProfit;

                now = parentMap.get(now);
                profit /= 10;

                if (profit < 1) {
                    break;
                }
            }
        }
        return answer;
    }
}
