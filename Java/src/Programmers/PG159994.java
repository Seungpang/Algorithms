package Programmers;

public class PG159994 {

    public static void main(String[] args) {
        final PG159994 pg159994 = new PG159994();
        System.out.println(
                pg159994.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{
                        "i", "want", "to", "drink", "water"}));

    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int cards1Idx = 0;
        int cards2Idx = 0;
        for (int i = 0; i < goal.length; i++) {
            if (cards1.length > cards1Idx && cards1[cards1Idx].equals(goal[i])) {
                cards1Idx++;
            }
            if (cards2.length > cards2Idx && cards2[cards2Idx].equals(goal[i])) {
                cards2Idx++;
            }
        }
        if (cards1Idx + cards2Idx == goal.length) {
            answer = "Yes";
        }
        return answer;
    }
}
