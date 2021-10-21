package Programmers;
//2021 카카오 채용연계형 인턴십
//숫자 문자열과 영단어

public class PG81301 {

    public static void main(String[] args) {
        PG81301 a = new PG81301();
        String s = "one4seveneight";
        System.out.println(a.solution(s));
    }

    public int solution(String s) {
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], nums[i]);
        }
        return Integer.parseInt(s);
    }
}
