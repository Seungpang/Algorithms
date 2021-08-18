package Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        test sol = new test();
        int[] gift_cards = {1, 2, 3, 4, 5};
        int[] wants = {2, 4, 4, 5, 1};
        System.out.println(sol.solution(gift_cards, wants));
    }
        public int solution(int[] gift_cards, int[] wants) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int answer = 0;
            for(int gift_card: gift_cards) {
                if (map.containsKey(gift_card)) {
                    count = map.get(gift_card);
                }
                map.put(gift_card, count+1);
                count = 0;
            }
            System.out.println(map);
            for(int want : wants) {
                if (map.containsKey(want)) {
                    map.put(want, map.get(want) - 1);
                }
            }
            System.out.println(map);
            for (int i : map.values())
                if (i > 0)
                    answer += i;
            return answer;
        }
}
//
//
//
//    Map<Integer, List<Integer>> cardIdx = new HashMap<>();
//
//    // 1<=gift_cards<=100,000
//    public int solution(int[] gift_cards, int[] wants) {
//
//        int answer = 0;
//
//        // 여분(원하지 않는) 카드 정보 생성
//        for (int i = 0; i < gift_cards.length; ++i) {
//            if (gift_cards[i] != wants[i]) {
//
//                List<Integer> cardList = cardIdx.get(gift_cards[i]);
//
//                if (cardList == null) {
//                    cardList = new ArrayList<Integer>();
//                }
//                cardList.add(i);
//                cardIdx.put(gift_cards[i], cardList);
//
//            }
//        }
//
//        for (int i = 0; i < gift_cards.length; ++i) {
//
//            int wantedCard = wants[i];
//
//            if (gift_cards[i] != wantedCard) {
//
//                List<Integer> cardList = cardIdx.get(wantedCard);
//
//                //shuffle
//                if (cardList != null) {
//                    gift_cards[cardList.get(0)] =  gift_cards[i];
//                    gift_cards[i] = wantedCard;
//                    cardList.remove(0);
//
//                    if(cardList.isEmpty()) {
//                        cardIdx.remove(wantedCard);
//                    }else {
//                        cardIdx.put(wantedCard, cardList);
//                    }
//
//                } else {
//                    answer++;
//                }
//
//            }
//        }
//
//        return answer;
//    }
//}
//
//		Solution sol = new Solution();
//
////		System.out.println(sol.solution(new int[] { 4, 5, 3, 2, 1 }, new int[] { 2, 4, 4, 5, 1 }));
//                System.out.println(sol.solution(new int[] { 5, 4, 5, 4, 5 }, new int[] { 1, 2, 3, 5, 4 }));