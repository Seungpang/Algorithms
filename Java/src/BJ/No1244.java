package BJ;
// 스위치 켜고 끄기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int j = num; j <= n; j += num) {
                    switches[j - 1] = switches[j - 1] == 0 ? 1 : 0;
                }
            } else {
                num--;
                int start = num - 1;
                int end = num + 1;
                switches[num] = switches[num] == 0 ? 1 : 0;
                while (start >= 0 && end < n) {
                    if (switches[start] == switches[end]) {
                        switches[start] = switches[start] == 0 ? 1 : 0;
                        switches[end] = switches[end] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                    start--;
                    end++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
