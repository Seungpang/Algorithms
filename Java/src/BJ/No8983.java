package BJ;
// 사냥꾼

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No8983 {
    static int M, N, L;
    static int[] shootingPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        shootingPoints = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            shootingPoints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shootingPoints);

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y > L) continue;

            int closestPoint = findClosestPoint(x);
            if (Math.abs(shootingPoints[closestPoint] - x) + y <= L) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int findClosestPoint(int x) {
        int left = 0;
        int right = M - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (shootingPoints[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left > 0 && Math.abs(shootingPoints[left - 1] - x) < Math.abs(shootingPoints[left] - x)) {
            return left - 1;
        }
        return left;
    }
}
