import java.util.*;

public class NaverWebtoon01 {

    public static void main(String[] args) {
        NaverWebtoon01 a = new NaverWebtoon01();
        int[] price = {32000, 18000, 42500};
        int[] discounts = {50, 20};
        System.out.println(a.solution(price, discounts));
    }

    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        int num = discounts.length - 1;

        Arrays.sort(discounts);
        Arrays.sort(prices);

        for (int price : prices) {
            answer += price;
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            if (num >= 0) {
                answer -= prices[i] * (discounts[num] / 100.0);
                num--;
            }
        }
        return answer;
    }
}

//    public static int solution(int[] prices, int[] discounts) {
//        int answer = 0;
//
//        Arrays.sort(prices);
//        Arrays.sort(discounts);
//
//        System.out.println(Arrays.toString(prices));
//        System.out.println(Arrays.toString(discounts));
//
//        int discountsLength = discounts.length-1;
//        for (int i = prices.length-1; i >= 0; i--) {
//
//            if (discountsLength >= 0) {
//                int price = prices[i];
//                double discount = discounts[discountsLength] / 100.0;
//
//                int pay = price - (int) (price * discount);
//
//                answer += pay;
//
//                discountsLength--;
//            } else {
//                answer += prices[i];
//            }
//
//        }
//
//        System.out.println(answer);
//        return answer;
//    }

