package Programmers;

public class PG133502 {

    public static void main(String[] args) {
        final PG133502 a = new PG133502();
        System.out.println(a.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
            while (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        return answer;
    }
}
