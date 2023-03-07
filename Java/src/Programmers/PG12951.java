package Programmers;

public class PG12951 {

    public static void main(String[] args) {
        final PG12951 pg12951 = new PG12951();
        System.out.println(pg12951.solution("3people unFollowed me"));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.toLowerCase().split("");
        boolean isFirst = true;

        for (String word : words) {
            if (isFirst) {
                sb.append(word.toUpperCase());
            } else {
                sb.append(word);
            }
            isFirst = word.equals(" ");
        }

        return sb.toString();
    }
}
