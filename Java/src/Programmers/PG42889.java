package Programmers;
//2019 KAKAO BLIND RECRUITMENT
//실패율

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG42889 {

    public static void main(String[] args) {
        PG42889 a = new PG42889();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(a.solution(N, stages)));
        System.out.println(3/0);
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int nPlayer = stages.length;
        int[] playerOnStage = new int[N+2];
        Arrays.sort(stages);
        for (int stage : stages) {
            playerOnStage[stage]++;
        }

        int remainingPlayers = nPlayer;
        List<Rate> result = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            if (remainingPlayers == 0) {
                result.add(new Rate(i, 0.0));
                continue;
            }
            double failure = (double) playerOnStage[i] / remainingPlayers;
            remainingPlayers -= playerOnStage[i];

            result.add(new Rate(i, failure));
        }
        Collections.sort(result);

        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i).stage;
        }
        return answer;
    }

    static class Rate implements Comparable<Rate> {
        int stage;
        Double rate;

        public Rate(int stage, Double rate) {
            this.stage = stage;
            this.rate = rate;
        }

        @Override
        public int compareTo(Rate r) {
            if (this.rate.equals(r.rate)) {
                return this.stage - r.stage;
            }
            return Double.compare(r.rate, this.rate);
        }
    }
}
