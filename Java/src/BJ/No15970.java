package BJ;
// 화살표 그리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No15970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> colorPoints = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int position = Integer.parseInt(input[0]);
            int color = Integer.parseInt(input[1]);

            colorPoints.putIfAbsent(color, new ArrayList<>());
            colorPoints.get(color).add(position);
        }

        int totalDistance = 0;

        for (List<Integer> points : colorPoints.values()) {
            Collections.sort(points);

            totalDistance += points.get(1) - points.get(0);

            for (int i = 1; i < points.size() - 1; i++) {
                totalDistance += Math.min(points.get(i) - points.get(i-1),
                        points.get(i+1) - points.get(i));
            }

            totalDistance += points.get(points.size()-1) - points.get(points.size()-2);
        }

        System.out.println(totalDistance);
    }
}
