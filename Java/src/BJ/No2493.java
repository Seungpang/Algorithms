package BJ;
// 탑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class No2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1;
            }

            stack.push(new int[]{i, heights[i]});
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
