package BJ;
// 수학은 비대면강의입니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19532 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

//        for (int x = -999; x < 1000; x++) {
//            for (int y = -999; y < 1000; y++) {
//                if (a * x + b * y == c && d * x + e * y == f) {
//                    System.out.println(x + " " + y);
//                    return;
//                }
//            }
//        }

        //크래머 공식을 사용한 방법
        int det = a * e - b * d;

        if (det != 0) {
            int x = (c * e - b * f) / det;
            int y = (a * f - c * d) / det;
            System.out.println(x + " " + y);
        }
    }
}
