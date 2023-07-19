package BJ;
// 서로소 평균

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        int count = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            if (gcd(X, A[i]) == 1) {
                count++;
                sum += A[i];
            }
        }

        System.out.printf("%.6f", sum / count);
    }

    static int gcd(int a, int b) {
        int c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
