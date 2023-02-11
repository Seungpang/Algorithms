package Programmers;

public class PG155652 {

    public static void main(String[] args) {
        final PG155652 pg155652 = new PG155652();
        System.out.println(pg155652.solution("aukks", "wbqd", 5));
    }

    public String solution(String s, String skip, int index) {
        char[] words = s.toCharArray();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < index; j++) {
                if (skip.contains(String.valueOf(words[i]))) {
                    j -= 1;
                }
                words[i]++;
                if (words[i] > 'z') {
                    words[i] -= 26;
                }
            }
        }
        return String.valueOf(words);
    }
}
