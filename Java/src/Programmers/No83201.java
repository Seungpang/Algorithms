package Programmers;

public class No83201 {

    public String solution(int[][] scores) {
        String answer = "";
        int size = scores.length,temp = 0,sum=0,min=101,max = 0,cnt=0;
        double result = 0;
        for(int i = 0; i < size; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            cnt = size - 1;
            sum = 0;

            for (int j = 0; j < size; j++) {
                if (i == j)
                    temp = scores[j][i];
                else {
                    sum += scores[j][i];
                    if (scores[j][i] < min)
                        min = scores[j][i];
                    if (scores[j][i] > max)
                        max = scores[j][i];
                }
            }
            if (min <= temp && temp <= max) {
                sum += temp;
                cnt++;
            }
            result = 1.0 * sum / cnt;
            answer += grade(result);
        }
        return answer;
    }

    public String grade(double avg) {
        if (90 <= avg)
            return "A";
        else if (80 <= avg)
            return "B";
        else if (70 <= avg)
            return "C";
        else if (50 <= avg)
            return "D";
        else return "F";
    }
}
