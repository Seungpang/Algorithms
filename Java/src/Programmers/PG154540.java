package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG154540 {
    boolean[][] visited;
    public static void main(String[] args) {
        final PG154540 pg154540 = new PG154540();
        System.out.println(Arrays.toString(pg154540.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int n = maps.length;
        visited = new boolean[n][maps[0].length()];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < maps[0].length(); j++) {
                sum = dfs(i, j, maps);
                if (sum > 0) {
                    answer.add(sum);
                }
            }
        }
        Collections.sort(answer);
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue)
                .toArray();
    }

    private int dfs(int i, int j, String[] maps) {
        if (i < 0 || j < 0 || i >= maps.length || j >= maps[0].length() || visited[i][j] || maps[i].charAt(j) == 'X') {
            return 0;
        }
        visited[i][j] = true;
        return (maps[i].charAt(j) - '0') + dfs(i - 1, j, maps) + dfs(i + 1, j, maps) + dfs(i, j - 1, maps) + dfs(i,
                j + 1, maps);
    }
}
