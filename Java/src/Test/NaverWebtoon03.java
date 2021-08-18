package Test;

public class NaverWebtoon03 {

    public static void main(String[] args) {
        NaverWebtoon03 a = new NaverWebtoon03();
        String s = "aabcbcdabc";
        String t = "abc";

        System.out.println(a.solution(s, t));
    }

    public int solution(String s, String t) {
        int result = 0;
        String str = s;

        while (str.contains(t)) {
            str = str.replaceFirst(t, "");
            System.out.println(str);
            result++;
        }

        return result;
    }
}
