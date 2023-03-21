package Programmers;

import java.util.LinkedList;

public class PG17680 {

    public static void main(String[] args) {
        final PG17680 pg17680 = new PG17680();
        System.out.println(pg17680.solution(3, new String[]{
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        }));
    }

    static int CACHE_HIT = 1;
    static int CACHE_MISS = 5;


    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * CACHE_MISS;

        int answer = 0;

        LinkedList<String> caches = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (caches.remove(city)) {
                caches.addFirst(city);
                answer += CACHE_HIT;
            } else {
                int size = caches.size();
                if (size == cacheSize) {
                    caches.pollLast();
                }
                caches.addFirst(city);
                answer += CACHE_MISS;
            }
        }

        return answer;
    }
}
