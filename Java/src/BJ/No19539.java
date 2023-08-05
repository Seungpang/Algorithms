package BJ;
// 사과나무

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int halfSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            sum += height;
            halfSum += height / 2;
        }

        if (sum % 3 == 0 && sum / 3 <= halfSum) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
