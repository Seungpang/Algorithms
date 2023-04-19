package Programmers;
// 압축

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG17684 {

    public static void main(String[] args) {
        final PG17684 pg17684 = new PG17684();
        System.out.println(Arrays.toString(pg17684.solution("KAKAO")));
    }

    public int[] solution(String msg) {
        List<String> dict = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        // 1번
        for (int i = 0; i < 26; i++) {
            dict.add(String.valueOf((char) ('A' + i)));
        }

        for (int i = 0; i < msg.length(); i++) {
            // 2번
            for (int j = dict.size() - 1; j >= 0; j--) {
                if (msg.substring(i).startsWith(dict.get(j))) {
                    i += dict.get(j).length() - 1;
                    //3번
                    answer.add(j + 1);
                    //4번
                    if (i + 1 < msg.length()) {
                        dict.add(dict.get(j) + msg.charAt(i + 1));
                    }
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue)
                .toArray();
    }
}
