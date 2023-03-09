package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG43164 {

    public static void main(String[] args) {
        final PG43164 pg43164 = new PG43164();
        System.out.println(Arrays.toString(pg43164.solution(new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        })));
    }

    boolean[] visited;
    List<String> tripRouters = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(tripRouters);
        return tripRouters.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String now, String path, int depth) {
        if (depth == tickets.length) {
            tripRouters.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], depth+1);
                visited[i] = false;
            }
        }
    }
}
