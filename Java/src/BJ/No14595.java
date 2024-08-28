package BJ;
// 동방 프로젝트 (Large)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] events = new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            events[x]++;
            events[y]--;
        }

        int count = 0;
        int currentSum = 0;
        for (int i = 1; i <= N; i++) {
            currentSum += events[i];
            if (currentSum == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
