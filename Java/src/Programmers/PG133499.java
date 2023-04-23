package Programmers;
// 옹알이 (2)
public class PG133499 {

    public static void main(String[] args) {
        final PG133499 pg133499 = new PG133499();
        System.out.println(pg133499.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(pg133499.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "asdfasdfasdf"}));
    }

    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble : babbling) {
            if (babble.contains("ayaaya") || babble.contains("yeye") || babble.contains("woowoo") || babble.contains(
                    "mama")) {
                continue;
            }
            babble = babble.replaceAll("aya|ye|woo|ma", "");

            if (babble.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
