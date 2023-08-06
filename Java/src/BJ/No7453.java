package BJ;
// 합이 0인 네 정수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 두 배열씩 합치기
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long result = 0;
        int abIndex = 0, cdIndex = n * n - 1;

        while (abIndex < n * n && cdIndex >= 0) {
            int sum = AB[abIndex] + CD[cdIndex];

            if (sum == 0) {
                long abCount = 0, cdCount = 0;
                int tempAB = AB[abIndex], tempCD = CD[cdIndex];

                while (abIndex < n * n && AB[abIndex] == tempAB) {
                    abCount++;
                    abIndex++;
                }
                while (cdIndex >= 0 && CD[cdIndex] == tempCD) {
                    cdCount++;
                    cdIndex--;
                }

                result += abCount * cdCount;
            } else if (sum > 0) {
                cdIndex--;
            } else {
                abIndex++;
            }
        }

        System.out.println(result);
    }
}
