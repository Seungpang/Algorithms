package BJ;
// 나무 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No14247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] trees = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i =0; i < n; i++) {
            trees[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees, (a, b) -> Integer.compare(a[1], b[1]));

        long result = 0;
        for (int day = 0; day < n; day++) {
            result += (long) trees[day][0] + (long) trees[day][1] * day;
            System.out.println(result);
        }

        System.out.println(result);
    }
}
