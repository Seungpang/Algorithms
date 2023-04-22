package Programmers;
// 광물 캐기

import java.util.Arrays;

public class PG172927 {

    public static void main(String[] args) {
        final PG172927 pg172927 = new PG172927();
        System.out.println(pg172927.solution(new int[]{1, 3, 2}, new String[]{
                "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
        }));
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int n = minerals.length / 5;
        int count = picks[0] + picks[1] + picks[2];
        int[][] arr = new int[n+1][3];
        for (int i = 0; i <= n; i++) {
            if (count == 0) {
                break;
            }
            count--;
            for (int j = i * 5; j < (i * 5) + 5; j++) {
                if (j == minerals.length) {
                    break;
                }
                if (minerals[j].equals("diamond")) {
                    arr[i][0] += 1;
                    arr[i][1] += 5;
                    arr[i][2] += 25;
                } else if (minerals[j].equals("iron")) {
                    arr[i][0] += 1;
                    arr[i][1] += 1;
                    arr[i][2] += 5;
                } else {
                    arr[i][0] += 1;
                    arr[i][1] += 1;
                    arr[i][2] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr, ((o1, o2) -> o2[2] - o1[2]));
        }

        for (int i = 0; i <= n; i++) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += arr[i][0];
            } else if (picks[1] > 0) {
                picks[1]--;
                answer += arr[i][1];
            } else if (picks[2] > 0) {
                picks[2]--;
                answer += arr[i][2];
            }
        }

        return answer;
    }
}
