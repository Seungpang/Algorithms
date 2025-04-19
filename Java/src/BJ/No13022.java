package BJ;
// 늑대와 올바른 단어

import java.util.Scanner;

public class No13022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValidWolfWord(s) ? 1 : 0);
    }

    public static boolean isValidWolfWord(String word) {
        if (word.isEmpty()) {
            return true;
        }

        int wCount = 0, oCount = 0, lCount = 0, fCount = 0;
        int state = 0;

        for (char c : word.toCharArray()) {
            switch (state) {
                case 0:
                    if (c == 'w') wCount++;
                    else if (c == 'o') {
                        state = 1;
                        oCount++;
                    } else return false;
                    break;
                case 1:
                    if (c == 'o') oCount++;
                    else if (c == 'l') {
                        if (oCount != wCount) return false;
                        state = 2;
                        lCount++;
                    } else return false;
                    break;
                case 2:
                    if (c == 'l') lCount++;
                    else if (c == 'f') {
                        if (lCount != wCount) return false;
                        state = 3;
                        fCount++;
                    } else return false;
                    break;
                case 3:
                    if (c == 'f') fCount++;
                    else if (c == 'w') {
                        if (fCount != wCount) return false;
                        return isValidWolfWord(word.substring(wCount + oCount + lCount + fCount));
                    } else return false;
                    break;
            }
        }

        return wCount == oCount && oCount == lCount && lCount == fCount;
    }
}
