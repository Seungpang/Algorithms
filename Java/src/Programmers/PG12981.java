package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG12981 {

    public static void main(String[] args) {
        final PG12981 pg12981 = new PG12981();
        System.out.println(Arrays.toString(pg12981.solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    public int[] solution(int n, String[] words) {
        List<String> arr = new ArrayList<>();
        int index = 0;
        arr.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!arr.contains(words[i])) {
                String prevWord = arr.get(index++);
                if (prevWord.charAt(prevWord.length() - 1) != words[i].charAt(0)) {
                    return fail(n, i);
                }
                arr.add(words[i]);
            } else {
                return fail(n, i);
            }
        }

        return new int[]{0, 0};
    }

    private int[] fail(int n, int i) {
        int num = (i % n) + 1;
        int order = (i / n) + 1;
        return new int[]{num, order};
    }
}
