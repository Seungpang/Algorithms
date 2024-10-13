package BJ;
// 고층 건물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int maxVisible = 0;
        for (int i = 0; i < N; i++) {
            int visible = 0;

            double maxSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(buildings[i] - buildings[j]) / (i - j);
                if (j == i - 1 || slope < maxSlope) {
                    maxSlope = slope;
                    visible++;
                }
            }

            maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(buildings[j] - buildings[i]) / (j - i);
                if (j == i + 1 || slope > maxSlope) {
                    maxSlope = slope;
                    visible++;
                }
            }

            maxVisible = Math.max(maxVisible, visible);
        }

        System.out.println(maxVisible);
    }
}
