package Programmers;
// 키패드 누르기

import java.util.*;
public class PG67256 {

    public static void main(String[] args) {
        PG67256 a = new PG67256();
        System.out.println(a.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(a.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(a.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    Map<Integer, int[]> keypad = new HashMap<>();

    public String solution(int[] numbers, String hand) {
        keypad.put(1, new int[]{0,0});
        keypad.put(2, new int[]{0,1});
        keypad.put(3, new int[]{0,2});
        keypad.put(4, new int[]{1,0});
        keypad.put(5, new int[]{1,1});
        keypad.put(6, new int[]{1,2});
        keypad.put(7, new int[]{2,0});
        keypad.put(8, new int[]{2,1});
        keypad.put(9, new int[]{2,2});
        keypad.put(0, new int[]{3,1});

        int[] leftThumb = {3,0};
        int[] rightThumb = {3,2};

        StringBuilder answer = new StringBuilder();
        for (int num : numbers) {
            int[] target = keypad.get(num);
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftThumb = target;
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightThumb = target;
            } else {
                int leftDistance = calculateDistance(leftThumb, target);
                int rightDistance = calculateDistance(rightThumb, target);

                if (leftDistance < rightDistance) {
                    answer.append("L");
                    leftThumb = target;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightThumb = target;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftThumb = target;
                    } else {
                        answer.append("R");
                        rightThumb = target;
                    }
                }
            }
        }
        return answer.toString();
    }

    public int calculateDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
