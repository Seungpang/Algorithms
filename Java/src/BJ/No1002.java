package BJ;
// 터렛

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distanceSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            int sumOfRadiiSquared = (r1 + r2) * (r1 + r2);
            int differenceOfRadiiSquared = (r1 - r2) * (r1 - r2);

            if (distanceSquared == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (distanceSquared == sumOfRadiiSquared || distanceSquared == differenceOfRadiiSquared) {
                System.out.println(1);
            } else if (distanceSquared > differenceOfRadiiSquared && distanceSquared < sumOfRadiiSquared) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}
