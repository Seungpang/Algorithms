package Programmers;

import java.util.Arrays;
import java.util.List;

//2021 Dev-Matching
//로또의 최고 순위와 최저 순위
public class PG77484 {

    public static void main(String[] args) {
        PG77484 a = new PG77484();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int num = 0;
        int zero_num = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero_num++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    num++;
                    break;
                }
            }
        }

        answer[0] = getRank(num + zero_num);
        answer[1] = getRank(num);

        return answer;
    }

    static int getRank(int num) {
        switch (num) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
