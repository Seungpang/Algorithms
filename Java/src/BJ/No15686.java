package BJ;
// 치킨 배달

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No15686 {
    static int N, M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int minTotalDistance = Integer.MAX_VALUE;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) houses.add(new Point(i, j));
                else if (value == 2) chickens.add(new Point(i, j));
            }
        }

        selectChickens(0, new ArrayList<>());

        System.out.println(minTotalDistance);
    }

    static void selectChickens(int index, List<Point> selected) {
        if (selected.size() == M) {
            minTotalDistance = Math.min(minTotalDistance, calculateTotalDistance(selected));
            return;
        }

        if (index == chickens.size()) {
            return;
        }

        selected.add(chickens.get(index));
        selectChickens(index + 1, selected);

        selected.remove(selected.size() - 1);
        selectChickens(index + 1, selected);
    }

    static int calculateTotalDistance(List<Point> selected) {
        int totalDistance = 0;
        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Point chicken : selected) {
                int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
