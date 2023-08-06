package BJ;
// 점프 점프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());

        int count = 0;
        while (P1 != P2 && count < 10000) {
            if (P1 < P2) {
                P1 += X;
            } else if (P1 > P2) {
                P2 += Y;
            }
            count++;
        }

        if (count == 10000) {
            System.out.println(-1);
        } else {
            System.out.println(P1);
        }
    }
}
