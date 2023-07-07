package Programmers;
// 카펫

import java.util.Arrays;

public class PG42842 {
    
    public static void main(String[] args) {
        PG42842 pg42842 = new PG42842();
        System.out.println(Arrays.toString(pg42842.solution(10, 2))); // [4,3]
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        for (int i=1; i<=area; i++) {
            int row = i;
            int col = area/row;
            if (col < row) {
                continue;
            }

            if ((row-2) * (col-2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        return answer;
    }
}
