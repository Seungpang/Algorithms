package BJ;
// 좋은 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No5624 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int goodCount = 0;

        Map<Integer, Boolean> prefixSums = new HashMap<>();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                prefixSums.put(nums[j] + nums[i - 1], true);
            }

            for (int j = 0; j < i; j++) {
                if (nums[j] * 3 == nums[i]) {
                    goodCount++;
                    break;
                }

                int left = nums[i] - nums[j];
                if (prefixSums.get(left) != null) {
                    goodCount++;
                    break;
                }
            }
        }

        System.out.println(goodCount);
    }
}
