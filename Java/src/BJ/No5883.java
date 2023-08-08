package BJ;
// 아이폰 9S

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class No5883 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] size = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            size[i] = Integer.parseInt(br.readLine());
            set.add(size[i]);
        }

        int maxLength = 1;
        for (int len : set) {
            int count = 1;
            int pre = size[0];
            for (int i = 1; i < N; i++) {
                if (size[i] == len) continue;
                if (pre != size[i]) {
                    count = 1;
                } else {
                    count++;
                    maxLength = Math.max(maxLength, count);
                }
                pre = size[i];
            }
        }

        System.out.println(maxLength);
    }
}
