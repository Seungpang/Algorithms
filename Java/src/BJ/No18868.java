package BJ;
// 멀티버스 Ⅰ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18868 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[M];

        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[N];
            for (int j = 0; j < N; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (temp[k] > temp[j]) sb.append('+');
                    else if (temp[k] < temp[j]) sb.append('-');
                    else sb.append('=');
                }
            }
            arr[i] = sb.toString();
        }

        int result = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (arr[i].equals(arr[j])) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
