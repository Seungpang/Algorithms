package WeeklyChallenge;

public class Week2 {

    public static void main(String[] args) {
        Week2 a = new Week2();
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67},
            {61, 57, 100, 80, 65}, {0, 0, 0, 0, 0}};
        System.out.println(a.solution(scores));
    }

    public String solution(int[][] scores) {
        String answer = "";
        int s = scores.length,temp = 0,sum=0,min=101,max = 0,cnt=0;
        double r=0;
        for(int i=0;i<s;i++) {
            sum = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            cnt = s - 1;
            for (int j = 0; j < s; j++) {
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
            r = 1.0 * sum / cnt;
            answer += grade(r);
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
