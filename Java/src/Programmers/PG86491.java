package Programmers;
// 최소직사각형

public class PG86491 {

    public static void main(String[] args) {
        PG86491 pg86491 = new PG86491();
        System.out.println(pg86491.solution(new int[][]{
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        }));
    }

    public int solution(int[][] sizes) {
        int x = 0, y = 0;
        for (int[] size : sizes) {
            x = Math.max(x, Math.max(size[0], size[1]));
            y = Math.max(y, Math.min(size[0], size[1]));
        }
        return x * y;
    }
}
