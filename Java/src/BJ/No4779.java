package BJ;
// 칸토어 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            int length = (int) Math.pow(3, N);
            char[] arr = new char[length];

            for (int i = 0; i < length; i++) {
                arr[i] = '-';
            }

            generateCantor(N, arr, 0, length);

            System.out.println(new String(arr));
        }
    }

    static void generateCantor(int N, char[] arr, int start, int length) {
        if (N == 0) {
            return;
        }

        int segmentLength = length / 3;

        for (int i = start + segmentLength; i < start + 2 * segmentLength; i++) {
            arr[i] = ' ';
        }

        generateCantor(N - 1, arr, start, segmentLength);
        generateCantor(N - 1, arr, start + 2 * segmentLength, segmentLength);
    }
}
