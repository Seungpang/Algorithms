package BJ;
// 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = true;
            } else if (command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = false;
            } else if (command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (arr[num]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = !arr[num];
            } else if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    arr[j] = true;
                }
            } else if (command.equals("empty")) {
                Arrays.fill(arr, false);
            }

        }
        System.out.println(sb);
    }
}
