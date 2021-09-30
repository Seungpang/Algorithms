package WeeklyChallenge;

import java.util.ArrayList;
import java.util.Arrays;

public class Week7 {

    public static void main(String[] args) {
        Week7 a = new Week7();
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};
        int[] enter2 = {1,4,2,3};
        int[] leave2 = {2,1,4,3};
        System.out.println(Arrays.toString(a.solution(enter, leave)));
        System.out.println(Arrays.toString(a.solution(enter2, leave2)));
    }

    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < leave.length; i++) {
            for (int j = idx; j < enter.length; j++) {
                if (answer[leave[i] - 1] > 0)
                    break;
                list.add(enter[j]);
                idx++;
                if (enter[j] == leave[i])
                    break;
            }
            list.remove(Integer.valueOf(leave[i]));
            for (int j = 0; j < list.size(); j++) {
                answer[list.get(j) - 1]++;
            }
            answer[leave[i] - 1] += list.size();
        }
        return answer;
    }
}
