import java.util.ArrayList;
import java.util.List;

public class NaverWebtoon02 {

    public static void main(String[] args) {
        NaverWebtoon02 a = new NaverWebtoon02();
        String s = "abcdef";
        System.out.println(a.solution(s));
    }

    public String[] solution(String s) {
        List<String> list = new ArrayList<>();
        String front = "";
        String back = "";

        int num = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            front = front + s.charAt(i);
            back = s.charAt(num) + back;

            if (front.equals(back)) {
                list.add(front);
                front = "";
                back = "";
            }
            num--;
        }

        return list.toArray(new String[0]);
    }
}
