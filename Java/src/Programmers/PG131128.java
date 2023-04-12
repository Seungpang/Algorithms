package Programmers;
// 숫자 짝꿍

public class PG131128 {

    public static void main(String[] args) {
        final PG131128 pg131128 = new PG131128();
        System.out.println(pg131128.solution("560340860394", "435634986793"));
    }

    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (int i=0; i<Math.max(X.length(), Y.length()); i++) {
            if (i < X.length()) {
                xCount[X.charAt(i) - '0']++;
            }
            if (i < Y.length()) {
                yCount[Y.charAt(i) - '0']++;
            }
        }

        for (int i=9; i>=0; i--) {
            sb.append(String.valueOf(i).repeat(Math.max(0, Math.min(xCount[i], yCount[i]))));
        }
        if (sb.length() == 0) {
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
