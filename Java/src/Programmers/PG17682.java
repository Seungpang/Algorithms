package Programmers;
//2018 KAKAO BLIND RECRUITMENT
//[1차] 다트 게임

public class PG17682 {

    public static void main(String[] args) {
        PG17682 a = new PG17682();
        System.out.println(a.solution("1S2D*3T"));
    }

    public int solution(String dartResult) {
        int answer = 0;
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        int cnt = -1;
        //S싱글,D더블,T트리플
        //*해당점수와 이전 점수 2배,#해당 점수 -된다.
        //*이 처음이면 처음만 2배 중첩가능
        //* #이 만나면 -2배가능

        for (int i = 0; i < dartResult.length(); i++) {
            if (darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if (darts[i] == '1' && darts[i + 1] == '0') {
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if (darts[i] == 'D') {
                score[cnt] *= score[cnt];
            } else if (darts[i] == 'T') {
                score[cnt] *= score[cnt] * score[cnt];
            } else if (darts[i] == '*') {
                if (cnt > 0) {
                    score[cnt - 1] *= 2;
                }
                score[cnt] *= 2;
            } else if (darts[i] == '#') {
                score[cnt] *= -1;
            }
        }
        return score[0] + score[1] + score[2];
    }
}
