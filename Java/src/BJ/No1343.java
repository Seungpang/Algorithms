package BJ;
// 폴리오미노

import java.util.Scanner;

public class No1343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                if (count > 0) {
                    if (!fillPolyomino(sb, count)) {
                        System.out.println("-1");
                        return;
                    }
                    count = 0;
                }
                sb.append(".");
            }
        }

        if (count > 0 && !fillPolyomino(sb, count)) {
            System.out.println("-1");
            return;
        }

        System.out.println(sb);
    }

    public static boolean fillPolyomino(StringBuilder sb, int count) {
        while (count >= 4) {
            sb.append("AAAA");
            count -= 4;
        }
        if (count == 2) {
            sb.append("BB");
            count -= 2;
        }
        return count == 0;
    }
}
