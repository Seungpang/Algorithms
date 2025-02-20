package BJ;
// 문자열 생성

import java.util.Scanner;

public class No6137 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] s = new char[N];

        for (int i = 0; i < N; i++) {
            s[i] = sc.next().charAt(0);
        }

        int left = 0;
        int right = N - 1;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (s[left] > s[right]) {
                sb.append(s[right--]);
            } else if (s[left] < s[right]) {
                sb.append(s[left++]);
            } else {
                int l = left;
                int r = right;
                boolean useLeft = false;

                while (l < r) {
                    if (s[l] < s[r]) {
                        useLeft = true;
                        break;
                    } else if (s[l] > s[r]) {
                        useLeft = false;
                        break;
                    }
                    l++;
                    r--;
                }

                if (useLeft) {
                    sb.append(s[left++]);
                } else {
                    sb.append(s[right--]);
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
            if ((i + 1) % 80 == 0) System.out.println();
        }
    }
}
