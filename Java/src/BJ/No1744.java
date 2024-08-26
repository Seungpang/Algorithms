package BJ;
// 수 묶기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) positive.add(num);
            else if (num < 0) negative.add(num);
            else if (num == 0) zeroCount++;
            else oneCount++;
        }

        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);

        long sum = oneCount;
        for (int i = 0; i < positive.size() - (positive.size() % 2); i += 2) {
            sum += (long) positive.get(i) * positive.get(i + 1);
        }
        if (positive.size() % 2 == 1) {
            sum += positive.get(positive.size() - 1);
        }

        for (int i = 0; i < negative.size() - (negative.size() % 2); i += 2) {
            sum += (long) negative.get(i) * negative.get(i+1);
        }
        if (negative.size() % 2 == 1) {
            if (zeroCount == 0) {
                sum += negative.get(negative.size() - 1);
            }
        }

        System.out.println(sum);
    }
}
