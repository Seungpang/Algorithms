package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋다
public class No1253 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int num = Integer.parseInt(stringTokenizer.nextToken());
        long[] a = new long[num];
        int result = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < num; i++) {
            a[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        Arrays.sort(a);
        for (int k = 0; k < num; k++) {
            long find = a[k];
            int i = 0;
            int j = num - 1;

            while (i < j) {
                if (a[i] + a[j] == find) {
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (a[i] + a[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}
