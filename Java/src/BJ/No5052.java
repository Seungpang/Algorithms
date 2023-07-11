package BJ;
// 전화번호 목록

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[n];

            for (int i = 0; i < n; i++) {
                phoneNumber[i] = br.readLine();
            }
            Arrays.sort(phoneNumber);

            boolean flag = false;
            for (int i = 0; i < phoneNumber.length - 1; i++) {
                if (phoneNumber[i + 1].startsWith(phoneNumber[i])) {
                    flag = true;
                    System.out.println("NO");
                    break;
                }
            }
            if (!flag) {
                System.out.println("YES");
            }
        }
    }
}
