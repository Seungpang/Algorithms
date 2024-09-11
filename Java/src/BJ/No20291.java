package BJ;
// 파일 정리

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class No20291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String file = sc.nextLine();
            String[] split = file.split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        Map<String, Integer> sortedMap = new TreeMap<>(map);

        for (String key : sortedMap.keySet()) {
            System.out.println(key + " " + sortedMap.get(key));
        }
    }
}
