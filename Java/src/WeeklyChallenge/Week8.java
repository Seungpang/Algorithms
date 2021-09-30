package WeeklyChallenge;

public class Week8 {

    public static void main(String[] args) {
        Week8 a = new Week8();
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(a.solution(sizes1));
        System.out.println(a.solution(sizes2));
        System.out.println(a.solution(sizes3));
    }

    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;

        for (int[] size : sizes) {
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);

            if (x > max) {
                max = x;
            }

            if (y > min) {
                min = y;
            }
        }
        return max * min;
    }
}
