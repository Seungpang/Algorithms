package BJ;
// 가장 긴 증가하는 부분 수열 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > list.get(list.size() - 1)) {
                list.add(value);
            } else {
                int left = 0;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) < value) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right, value);
            }
        }
        System.out.println(list.size() - 1);
    }
}
