package BJ;
// 민겸 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(getMaxValue(input));
        System.out.println(getMinValue(input));
    }

    public static String getMaxValue(String s) {
        StringBuilder sb = new StringBuilder();
        int mCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                mCount++;
            } else {
                sb.append("5");
                sb.append("0".repeat(mCount));
                mCount = 0;
            }
        }
        if (mCount > 0) {
            for (int i = 0; i < mCount; i++) {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    public static String getMinValue(String s) {
        StringBuilder sb = new StringBuilder();
        int mCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                mCount++;
            } else {
                if (mCount > 0) {
                    sb.append("1");
                    sb.append("0".repeat(mCount - 1));
                    mCount = 0;
                }
                sb.append("5");
            }
        }
        if (mCount > 0) {
            sb.append("1");
            sb.append("0".repeat(mCount - 1));
        }
        return sb.toString();
    }
}
