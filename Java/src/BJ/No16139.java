package BJ;
// 인간-컴퓨터 상호작용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] preSum = new int['z' - 'a' + 1][S.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            for (int j = 0; j < preSum.length; j++) {
                char ch = (char) (j + 'a');
                preSum[j][i] = preSum[j][i - 1] + (c == ch ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int index = c - 'a';
            sb.append(preSum[index][r + 1] - preSum[index][l]).append("\n");
        }

        System.out.print(sb);
    }
}
