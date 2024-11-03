package BJ;
// 금민수의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1527 {

    static List<Long> geumminsuList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        generateGeumminsu(0);

        int count = 0;
        for (long num : geumminsuList) {
            if (num >= A && num <= B) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void generateGeumminsu(long num) {
        if (num > 1_000_000_000) return;

        if (num != 0) {
            geumminsuList.add(num);
        }

        generateGeumminsu(num * 10 + 4);
        generateGeumminsu(num * 10 + 7);
    }
}
