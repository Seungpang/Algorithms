package BJ;
// 적어도 대부분의 배수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        while (true) {
            int count = 0;

            for (int number : numbers) {
                if (result % number == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(result);
                break;
            }

            result++;
        }
    }
}
