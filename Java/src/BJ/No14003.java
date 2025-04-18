package BJ;
// 가장 긴 증가하는 부분 수열 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int[] lisIndex = new int[n];

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
            lisIndex[i] = pos;
        }

        int lisLength = lis.size();
        System.out.println(lisLength);

        int[] result = new int[lisLength];
        int lastIndex = lisLength - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (lisIndex[i] == lastIndex) {
                result[lastIndex] = arr[i];
                lastIndex--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
